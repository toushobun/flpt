package com.service.user;

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
		// TODO Auto-generated method stub
		Reginfo reginfoToSelect = new Reginfo();
		reginfoToSelect.setUser_id(user_id);
		List<Reginfo> reginfoList = reginfoDao.selectReginfoByKwargs(reginfoToSelect);
		model.addAttribute("reginfo", new Reginfo());
		model.addAttribute("reginfoList", reginfoList);
		return "user/reginfo/selectReginfo";
	}

	@Override
	public String addReginfo(Reginfo reginfo, Model model) {
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
			model.addAttribute("msg", "取消成功！");
			return "forward:/userCenter/center";
		} catch (Exception e) {
			model.addAttribute("msg", "取消失败！");
			return "forward:/userCenter/center";
		}
	}

	@Override
	public String selectAReginfo(Reginfo reginfo, Model model) {
		// TODO Auto-generated method stub
		reginfo = reginfoDao.selectReginfoByKwargs(reginfo).get(0);
		model.addAttribute("reginfo", reginfo);
		return "user/reginfo/selectAReginfo";
	}

	@Override
	public String searchReginfo(Reginfo reginfo, Model model) {
		List<Reginfo> reginfoList = reginfoDao.selectReginfoFuzzily(reginfo);
		model.addAttribute("reginfo", reginfo);
		model.addAttribute("reginfoList", reginfoList);
		return "user/reginfo/selectReginfo";
	}

}
