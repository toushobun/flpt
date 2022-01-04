package com.service.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		try {
			Reginfo reginfoToSelect = new Reginfo();
			reginfoToSelect.setUser_id(reginfo.getUser_id());
			reginfoToSelect.setTestinfo_id(reginfo.getTestinfo_id());
			List<Reginfo> reginfoList = reginfoDao.selectReginfoByKwargs(reginfoToSelect);
			Integer status;
			for (int i = 0; i < reginfoList.size(); i++) {
				status = reginfoList.get(i).getStatus();
				if (status == 0 || status == 1) {
					model.addAttribute("msg", "您已报名！请勿重复操作！");
					return "forward:/userTestinfo/selectTestinfo";
				}
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
			return "forward:/userReginfo/selectReginfo?user_id=" + reginfo.getUser_id();
		} catch (Exception e) {
			model.addAttribute("msg", "报名失败！");
			return "forward:/userTestinfo/selectTestinfo";
		}
	}

	@Override
	public String deleteReginfo(Integer reginfo_id, Model model) {
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
		try {
			reginfoDao.deleteReginfoByReginfo_id(reginfo.getReginfo_id());
			model.addAttribute("msg", "删除成功！");
			return "forward:/userReginfo/selectReginfo?user_id=" + reginfo.getUser_id();
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！");
			return "forward:/userReginfo/selectReginfo?user_id=" + reginfo.getUser_id();
		}
	}

	@Override
	public String toChangeRoom(Integer reginfo_id, Model model) {
		Reginfo reginfoToSelect = new Reginfo();
		reginfoToSelect.setReginfo_id(reginfo_id);
		Reginfo reginfo = reginfoDao.selectReginfoByKwargs(reginfoToSelect).get(0);
		TestinfoRoom testinfoRoomToSelect = new TestinfoRoom();
		testinfoRoomToSelect.setTestinfoRoom_id(reginfo.getTestinfoRoom_id());
		Integer testinfo_id = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToSelect).get(0).getTestinfo_id();
		testinfoRoomToSelect = new TestinfoRoom();
		testinfoRoomToSelect.setTestinfo_id(testinfo_id);
		List<TestinfoRoom> testinfoRoomList = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToSelect);
		boolean ifInTime; // ②是否在报名时间内
		boolean ifHaveQuota; // ①名额是否足够
		TestinfoRoom testinfoRoom = new TestinfoRoom();
		for (int i = 0; i < testinfoRoomList.size(); i++) {
			testinfoRoom = testinfoRoomList.get(i);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			Date date1 = null;
			Date date2 = null;
			try {
				date1 = sf.parse(testinfoRoom.getRegist_start_time()); // 获取报名开始时间
				date2 = sf.parse(testinfoRoom.getRegist_end_time()); // 获取报名截止时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date date = new Date(); // 获取当前系统时间
			ifInTime = MyUtil.isInTime(date, date1, date2); // 判断是否在报名时间内
			ifHaveQuota = testinfoRoom.getRquota() > 0; // 判断名额是否足够
			// 状态，1可报名，-1名额已满，-2不在报名时间，0名额已满且不在报名时间
			if (ifInTime && ifHaveQuota) {
				testinfoRoom.setStatus(1);
			} else if (ifInTime && !ifHaveQuota) {
				testinfoRoom.setStatus(-1);
			} else if (!ifInTime && ifHaveQuota) {
				testinfoRoom.setStatus(-2);
			} else {
				testinfoRoom.setStatus(0);
			}
			if (reginfo.getTestinfoRoom_id().equals(testinfoRoom.getTestinfoRoom_id())) {
				testinfoRoom.setStatus(-3);
			}
			testinfoRoomList.set(i, testinfoRoom);
		}
		model.addAttribute("reginfo_id", reginfo_id);
		model.addAttribute("testinfoRoomList", testinfoRoomList);
		return "user/reginfo/changeRoom";
	}

	@Override
	public String changeRoom(Reginfo reginfo, Model model) {
		try {
			// 先查看新考场是否有名额
			TestinfoRoom testinfoRoomToSelect = new TestinfoRoom();
			testinfoRoomToSelect.setTestinfoRoom_id(reginfo.getTestinfoRoom_id());
			TestinfoRoom testinfoRoom = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToSelect).get(0);
			if (testinfoRoom.getRquota() <= 0) {
				model.addAttribute("msg", "名额已满！");
				return "forward:/userReginfo/selectReginfo";
			}
			// 再减少新考场的名额
			TestinfoRoom testinfoRoomToUpdate = new TestinfoRoom();
			testinfoRoomToUpdate.setTestinfoRoom_id(reginfo.getTestinfoRoom_id());
			testinfoRoomToUpdate.setRquota(testinfoRoom.getRquota() - 1);
			testinfoRoomDao.updateTestinfoRoom(testinfoRoomToUpdate);
			// 再增加旧考场的名额
			Reginfo reginfoToSelect = new Reginfo();
			reginfoToSelect.setReginfo_id(reginfo.getReginfo_id());
			Reginfo oldReginfo = reginfoDao.selectReginfoByKwargs(reginfoToSelect).get(0);

			testinfoRoomToSelect = new TestinfoRoom();
			testinfoRoomToSelect.setTestinfoRoom_id(oldReginfo.getTestinfoRoom_id());
			testinfoRoom = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToSelect).get(0);

			testinfoRoomToUpdate = new TestinfoRoom();
			testinfoRoomToUpdate.setTestinfoRoom_id(oldReginfo.getTestinfoRoom_id());
			testinfoRoomToUpdate.setRquota(testinfoRoom.getRquota() + 1);
			testinfoRoomDao.updateTestinfoRoom(testinfoRoomToUpdate);
			// 最后更新准考证考场
			Reginfo reginfoToUpdate = reginfo;
			reginfoDao.updateReginfo(reginfoToUpdate);
			model.addAttribute("msg", "修改成功！");
			return "forward:/userReginfo/selectReginfo";
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "forward:/userReginfo/selectReginfo";
		}
	}

	@Override
	public String cancelReg(Integer reginfo_id, Model model) {
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
		try {
			reginfo.setStatus(2);
			reginfoDao.updateReginfo(reginfo);
			model.addAttribute("msg", "取消成功！");
			return "forward:/userReginfo/selectReginfo?user_id=" + reginfo.getUser_id();
		} catch (Exception e) {
			model.addAttribute("msg", "取消失败！");
			return "forward:/userReginfo/selectReginfo?user_id=" + reginfo.getUser_id();
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

	@Override
	public String toPay(Integer reginfo_id, Model model) {
		model.addAttribute("reginfo_id", reginfo_id);
		return "user/reginfo/pay";
	}

	@Override
	public String pay(Integer reginfo_id, Model model) {
		Reginfo reginfoToUpdate = new Reginfo();
		reginfoToUpdate.setReginfo_id(reginfo_id);
		reginfoToUpdate.setStatus(1);
		reginfoDao.updateReginfo(reginfoToUpdate);
		model.addAttribute("msg", "支付成功！");
		return "forward:/userReginfo/selectReginfo";
	}

	@Override
	public String createTicket(Integer reginfo_id, Model model) {
		Reginfo reginfoToSelect = new Reginfo();
		reginfoToSelect.setReginfo_id(reginfo_id);
		model.addAttribute("reginfo", reginfoDao.selectReginfoByKwargs(reginfoToSelect).get(0));
		return "user/reginfo/ticket";
	}

}
