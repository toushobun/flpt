package com.service.user;

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
import com.util.MyUtil;

@Service("userReginfoService")
@Transactional
public class UserReginfoServiceImpl implements UserReginfoService {

	@Autowired
	private ReginfoDao reginfoDao;

	@Autowired
	private TestinfoRoomDao testinfoRoomDao;

	@Override
	public String selectReginfo(Integer user_id, Model model) {
		Reginfo reginfoToSelect = new Reginfo();
		reginfoToSelect.setUser_id(user_id);
		List<Reginfo> reginfoList = reginfoDao.selectReginfoByKwargs(reginfoToSelect);
		String[] statuss = { "未支付", "已支付", "已取消", "已超时" };
		model.addAttribute("statuss", statuss);
		model.addAttribute("reginfo", new Reginfo());
		model.addAttribute("reginfoList", reginfoList);
		return "user/reginfo/selectReginfo";
	}

	@Override
	public String addReginfo(Reginfo reginfo, Model model) {
		// TODO 判断考生是否报名了此考试，要改为判断是否存在且status不为取消状态，而不是仅仅判断是否存在
		try {
			// 如果该考生已报名此考试，则为0，否则为1
			Reginfo reginfoToSelect = new Reginfo();
			reginfoToSelect.setUser_id(reginfo.getUser_id());
			reginfoToSelect.setTestinfo_id(reginfo.getTestinfo_id());
			if (reginfoDao.selectReginfoByKwargs(reginfoToSelect).size() > 0) {
				model.addAttribute("msg", "您已报名！请勿重复操作！");
				return "forward:/userTestinfo/selectTestinfo";
			}
			// 年份后两位+绑定ID后三位+考生ID后三位+随机数四位
			String ticketnum = "";
			reginfoToSelect = new Reginfo();
			// 搜索到存在则重新生成随机数
			while (true) {
				ticketnum = MyUtil.getStringID().substring(2, 4) + String.format("%03d", reginfo.getTestinfoRoom_id())
						+ String.format("%03d", reginfo.getUser_id())
						+ String.format("%04d", Math.round(Math.random() * 9999 + 1));
				reginfoToSelect.setTicketnum(ticketnum);
				if (reginfoDao.selectReginfoByKwargs(reginfoToSelect).size() == 0) {
					break;
				}
			}
			TestinfoRoom testinfoRoomToUpdate = new TestinfoRoom();
			testinfoRoomToUpdate.setTestinfoRoom_id(reginfo.getTestinfoRoom_id());
			Integer rquota = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToUpdate).get(0).getRquota();
			if (rquota <= 0) {
				model.addAttribute("msg", "报名失败！名额已满！");
				return "forward:/userTestinfo/selectTestinfo";
			}
			testinfoRoomToUpdate.setRquota(rquota - 1);
			testinfoRoomDao.updateTestinfoRoom(testinfoRoomToUpdate);

			reginfo.setTicketnum(ticketnum);
			reginfo.setStatus(0);
			reginfoDao.addReginfo(reginfo);
			model.addAttribute("msg", "报名成功！");
			return "forward:/userTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "报名失败！");
			return "forward:/userTestinfo/selectTestinfo";
		}
	}

	@Override
	public String deleteReginfo(Integer reginfo_id, Model model) {
		try {
			reginfoDao.deleteReginfoByReginfo_id(reginfo_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/userCenter/center";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！");
			return "forward:/userCenter/center";
		}
	}

	@Override
	public String cancelReg(Integer reginfo_id, Model model) {
		// TODO Auto-generated method stub
		try {
			Reginfo reginfoToUpdate = new Reginfo();
			reginfoToUpdate.setReginfo_id(reginfo_id);
			reginfoToUpdate.setStatus(2);
			reginfoDao.updateReginfo(reginfoToUpdate);
			model.addAttribute("msg", "取消成功！");
			return "forward:/userReginfo/selectAReginfo?reginfo_id=" + reginfo_id;
		} catch (Exception e) {
			model.addAttribute("msg", "取消失败！");
			return "forward:/userReginfo/selectAReginfo?reginfo_id=" + reginfo_id;
		}
	}

	@Override
	public String selectAReginfo(Reginfo reginfo, Model model) {
		reginfo = reginfoDao.selectReginfoByKwargs(reginfo).get(0);
		model.addAttribute("reginfo", reginfo);
		return "user/reginfo/selectAReginfo";
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
		return "user/reginfo/selectReginfo";
	}

}
