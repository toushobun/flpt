package com.service.before;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminTestinfoDao;
import com.dao.UserReginfoDao;
import com.entity.Reginfo;
import com.entity.Testinfo;
import com.entity.Testinfo__room;
import com.util.MyUtil;

@Service("userReginfoService")
@Transactional
public class UserReginfoServiceImpl implements UserReginfoService {
	
	@Autowired
	private UserReginfoDao userReginfoDao;
	@Autowired
	private AdminTestinfoDao adminTestinfoDao;
	
	@Override
	public String userSelectTestinfo(HttpSession session) {
		// TODO 考生选择想要报名的考试
		List<Testinfo> testinfoList = userReginfoDao.userSelectTestinfo();
		for(int i=0;i<testinfoList.size();i++) {
			Testinfo testinfo = testinfoList.get(i);
			// 如果该考生已报名此考试，则为0，否则为1
			if(userReginfoDao.userSelectReginfoByTestinfo_id(testinfo.getTestinfo_id()).size() > 0) {
				testinfo.setStatus(0);
			}
			else {
				testinfo.setStatus(1);
			}
			testinfoList.set(i, testinfo);
		}
		session.setAttribute("allTestinfo", testinfoList);
		// 这个指令将转到本地文件层验证
		return "before/userSelectTestinfo";
	}
	
	@Override
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model) {
		// TODO 考生选择该考试的考场
		List<Testinfo__room> testinfo__roomList = userReginfoDao.userSelectTestinfo__room(testinfo_id);
		testinfo__roomList = MyUtil.pushTestinfo__roomToBuser(testinfo__roomList);
		model.addAttribute("allTestinfo__room", testinfo__roomList);
		return "before/userSelectTestinfoRoom";
	}
	
	@Override
	public String userAddReginfo(Reginfo reginfo, Model model) {
		// TODO 将考生提交的准考证信息写入数据库
		Testinfo__room testinfo__room = userReginfoDao.userSelectTestinfo__roomByTestinfo__room_id(reginfo.getTestinfo__room_id());
		// 准考证的组成：1~2位是年份，3~4位是考试编号后两位，5~6位是考场编号后两位，
		// 7~8位是考生id后两位（X识别为0），9~12位是候补位，如果重复则整体+1直到不重复为止
		String ticketnum_default = testinfo__room.getTest_time().substring(2,4) + 
				testinfo__room.getTestinfo_id()%100 +
				testinfo__room.getRoom_id()%100 +
				reginfo.getUser_id()%100;
		String ticketnum = null;
		do {
			ticketnum = ticketnum_default + String.format("%04d", Math.round(Math.random()*9999+1));
		}
		while(userReginfoDao.userSelectReginfoByTicketnum(ticketnum).size() > 0) ;
		reginfo.setTicketnum(ticketnum);
		testinfo__room.setRquota(testinfo__room.getRquota() - 1);
		if(userReginfoDao.userSelectTestinfo__roomByTestinfo__room_id(reginfo.getTestinfo__room_id()).getRquota() <= 0) {
			model.addAttribute("msg", "报名失败！，名额已满！");
		}
		if(adminTestinfoDao.updateTestinfo__room(testinfo__room) > 0 && userReginfoDao.userAddReginfo(reginfo) > 0){
			model.addAttribute("msg", "报名成功！");
		}
		return "forward:/userReginfo/userSelectTestinfo";
	}
	
	@Override
	public String userSelectAReginfoByUser_idAndTestinfo_id(Reginfo reginfo, Model model) {
		// TODO 通过考生id和考试信息搜索一个准考证
		model.addAttribute("reginfo", userReginfoDao.userSelectAReginfoByUser_idAndTestinfo_id(reginfo));
		return "before/userSelectAReginfo";
	}
	@Override
	public String userToPay(Reginfo reginfo, Model model) {
		// TODO 考生前往支付页
		model.addAttribute("reginfo", reginfo);
		return "before/userPay";
	}
	
	@Override
	public String userPay(Integer reginfo_id, Model model) {
		// TODO 考生支付考试
		Reginfo reginfo = new Reginfo();
		reginfo.setStatus(1);
		reginfo.setReginfo_id(reginfo_id);
		if(userReginfoDao.userUpdateReginfo(reginfo) > 0) {
			model.addAttribute("reginfo", userReginfoDao.userSelectAReginfoByReginfo_id(reginfo_id));
			model.addAttribute("msg", "支付成功！");
		}
		return "before/userSelectAReginfo";
	}
	
	@Override
	public String userCancelReginfo(Integer reginfo_id, Model model) {
		// TODO 考生取消报名考试
		Reginfo reginfo = userReginfoDao.userSelectAReginfoByReginfo_id(reginfo_id);
		Testinfo__room testinfo__room = userReginfoDao.userSelectTestinfo__roomByTestinfo__room_id(reginfo.getTestinfo__room_id());
		testinfo__room.setRquota(testinfo__room.getRquota() + 1);
		if(adminTestinfoDao.updateTestinfo__room(testinfo__room) > 0 && userReginfoDao.userDeleteReginfoByReginfo_id(reginfo_id) > 0) {
			model.addAttribute("msg", "取消成功！");
		}
		return "before/userCenter";
	}
	
	@Override
	public String userToChangeRoom(Reginfo reginfo, Model model) {
		// TODO 考生前往更换报名的考场
		// 通过考试信息考场关联表，找到对应考场的考试信息id
		Testinfo__room oldTestinfo__room = userReginfoDao.userSelectTestinfo__roomByTestinfo__room_id(reginfo.getTestinfo__room_id());
		List<Testinfo__room> testinfo__roomList = userReginfoDao.userSelectTestinfo__room(oldTestinfo__room.getTestinfo_id());
		testinfo__roomList = MyUtil.pushTestinfo__roomToBuser(testinfo__roomList);
		model.addAttribute("oldTestinfo__room", oldTestinfo__room);
		model.addAttribute("allTestinfo__room", testinfo__roomList);
		model.addAttribute("reginfo", reginfo);
		return "before/userChangeRoom";
	}
	
	@Override
	public String userChangeRoom(Reginfo reginfo, Model model) {
		// TODO 用户提交修改考场
		// 旧考场的名额+1
		Testinfo__room oldTestinfo__room = userReginfoDao.userSelectTestinfo__roomByTestinfo__room_id(reginfo.getOldTestinfo__room_id());
		oldTestinfo__room.setRquota(oldTestinfo__room.getRquota() + 1);
		// 新考场的名额-1
		Testinfo__room testinfo__room = userReginfoDao.userSelectTestinfo__roomByTestinfo__room_id(reginfo.getTestinfo__room_id());
		testinfo__room.setRquota(testinfo__room.getRquota() - 1);
		if(userReginfoDao.userSelectTestinfo__roomByTestinfo__room_id(reginfo.getTestinfo__room_id()).getRquota() <= 0) {
			model.addAttribute("msg", "修改失败！，名额已满！");
		}
		else if(userReginfoDao.userUpdateReginfo(reginfo) > 0 && adminTestinfoDao.updateTestinfo__room(testinfo__room) > 0 && adminTestinfoDao.updateTestinfo__room(oldTestinfo__room) > 0) {
			model.addAttribute("reginfo", userReginfoDao.userSelectAReginfoByReginfo_id(reginfo.getReginfo_id()));
			model.addAttribute("msg", "修改成功！");
		}
		return "before/userSelectAReginfo";
	}
	
	@Override
	public String userGetTicket(Reginfo reginfo, Model model) {
		// TODO 生成准考证
		model.addAttribute("reginfo", userReginfoDao.userSelectAReginfoByUser_idAndTestinfo_id(reginfo));
		return "before/userSelectTicket";
	}
	
	@Override
	public String userSelectReginfoByUser_id(Integer user_id, Model model) {
		// TODO 用户查找自己的准考证
		model.addAttribute("allReginfo", userReginfoDao.userSelectReginfoByUser_id(user_id));
		return "before/userSelectReginfo";
	}

}
