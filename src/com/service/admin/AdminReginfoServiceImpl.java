package com.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.ReginfoDao;
import com.dao.TestinfoRoomDao;
import com.entity.Reginfo;
import com.entity.TestinfoRoom;

@Service("adminReginfoService")
@Transactional
public class AdminReginfoServiceImpl implements AdminReginfoService {

	@Autowired
	private ReginfoDao reginfoDao;

	@Autowired
	private TestinfoRoomDao testinfoRoomDao;

	@Override
	public String selectReginfo(Model model) {
		List<Reginfo> reginfoList = reginfoDao.selectReginfoByKwargs(null);
		String[] statuss = { "未支付", "已支付", "已取消", "已超时" };
		model.addAttribute("statuss", statuss);
		model.addAttribute("reginfo", new Reginfo());
		model.addAttribute("reginfoList", reginfoList);
		return "admin/reginfo/selectReginfo";
	}

	@Override
	public String deleteReginfo(Integer reginfo_id, Model model) {
		try {
			Reginfo reginfoToSelect = new Reginfo();
			reginfoToSelect.setReginfo_id(reginfo_id);
			Reginfo reginfo = reginfoDao.selectReginfoByKwargs(reginfoToSelect).get(0);
			if (reginfo.getStatus() == 0 || reginfo.getStatus() == 1) {
				TestinfoRoom testinfoRoomToUpdate = new TestinfoRoom();
				testinfoRoomToUpdate.setTestinfoRoom_id(reginfo.getTestinfoRoom_id());
				Integer rquota = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToUpdate).get(0).getRquota();
				testinfoRoomToUpdate.setRquota(rquota + 1);
				testinfoRoomDao.updateTestinfoRoom(testinfoRoomToUpdate);
			}
			reginfoDao.deleteReginfoByReginfo_id(reginfo_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminReginfo/selectReginfo";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！");
			return "forward:/adminReginfo/selectReginfo";
		}
	}

	@Override
	public String searchReginfo(Reginfo reginfo, Model model) {
		List<Reginfo> reginfoList = new ArrayList<Reginfo>();
		List<Reginfo> reginfoSelectList = new ArrayList<Reginfo>();
		String[] statuss = reginfo.getStatuss();
		if (statuss.length == 0) {
			reginfoList = reginfoDao.selectReginfoFuzzily(reginfo);
		} else {
			for (int i = 0; i < statuss.length; i++) {
				if ("未支付".equals(statuss[i])) {
					reginfo.setStatus(0);
				} else if ("已支付".equals(statuss[i])) {
					reginfo.setStatus(1);
				} else if ("已取消".equals(statuss[i])) {
					reginfo.setStatus(2);
				} else if ("已超时".equals(statuss[i])) {
					reginfo.setStatus(3);
				}
				reginfoSelectList = reginfoDao.selectReginfoFuzzily(reginfo);
				for (int j = 0; j < reginfoSelectList.size(); j++) {
					reginfoList.add(reginfoSelectList.get(j));
				}
			}
		}
		String[] statussNew = { "未支付", "已支付", "已取消", "已超时" };
		model.addAttribute("statuss", statussNew);
		model.addAttribute("reginfo", reginfo);
		model.addAttribute("reginfoList", reginfoList);
		return "admin/reginfo/selectReginfo";
	}

}
