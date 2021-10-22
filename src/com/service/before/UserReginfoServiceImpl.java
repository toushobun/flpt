package com.service.before;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.UserReginfoDao;
import com.entity.Reginfo;
import com.entity.Testinfo;
import com.entity.Testinfo__Room;
import com.util.MyUtil;

@Service("userReginfoService")
@Transactional
public class UserReginfoServiceImpl implements UserReginfoService {
	@Autowired
	private UserReginfoDao userReginfoDao;
	@Override
	public String userSelectTestinfo(Model model) {
		// TODO 考生选择想要报名的考试
		List<Testinfo> testinfoList = userReginfoDao.userSelectTestinfo();		
		model.addAttribute("allTestinfo", testinfoList);
		// 这个指令将转到本地文件层验证
		return "before/userSelectTestinfo";
	}
	@Override
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model) {
		// TODO 考生选择该考试的考场
		Testinfo__Room testinfo__Room = userReginfoDao.userSelectTestinfo__Room(testinfo_id);
		boolean ifInTime;			// ②是否在报名时间内
		boolean ifHaveQuota;		// ①名额是否足够
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = sf.parse(testinfo__Room.getRegist_start_time());			// 获取报名开始时间
			date2 = sf.parse(testinfo__Room.getRegist_end_time());		// 获取报名截止时间
		} catch (ParseException e) {e.printStackTrace();}		
		Date date = new Date();		// 获取当前系统时间
		ifInTime = MyUtil.isEffectiveDate(date, date1, date2);		// 判断是否在报名时间内
		ifHaveQuota = testinfo__Room.getRquota() > 0;						// 判断名额是否足够
		// 状态，1可报名，0名额已满，-1不在报名时间，-2名额已满且不在报名时间
		if(ifInTime && ifHaveQuota){
			testinfo__Room.setStatus(1);
		}
		else if(ifInTime && !ifHaveQuota) {
			testinfo__Room.setStatus(0);
		}
		else {
			testinfo__Room.setStatus(-1);
		}
		model.addAttribute("allTestinfo__Room", testinfo__Room);
		return "before/userSelectTestinfoRoom";
	}
	@Override
	public String userAddReginfo(Reginfo reginfo, Model model) {
		// TODO 将考生提交的准考证信息写入数据库
		Testinfo__Room testinfo__Room = userReginfoDao.userSelectTestinfo__Room(reginfo.getTestinfo_id());
		// 准考证的组成：1~2位是年份，3~4位是考试编号后两位，5~6位是考场编号后两位，
		// 7~8位是考生id后两位（X识别为0），9~12位是候补位，如果重复则整体+1直到不重复为止
		String ticketnum_default = testinfo__Room.getTest_time().substring(2,4) + 
				testinfo__Room.getTestinfo_id()%100 +
				testinfo__Room.getRoom_id()%100 +
				reginfo.getUser_id()%100;
		String ticketnum = null;
		do {
			ticketnum = ticketnum_default + String.format("%04d", Math.random()*9998+1);
		}
		while(userReginfoDao.userSelectReginfoByTicketnum(ticketnum).size() > 0) ;
		reginfo.setTicketnum(ticketnum);
		if(userReginfoDao.userAddReginfo(reginfo) > 0){
			
		}
		return null;
	}

}
