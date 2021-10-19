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
import com.entity.Testinfo__Room;
import com.util.MyUtil;

@Service("userReginfoService")
@Transactional
public class UserReginfoServiceImpl implements UserReginfoService {
	@Autowired
	private UserReginfoDao userReginfoDao;
	@Override
	public String userSelectTestinfo(Model model) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Testinfo__Room> testinfo__RoomList = userReginfoDao.userSelectTestinfo__Room();
		boolean ifInTime;			// ②是否在报名时间内
		boolean ifHaveQuota;		// ①名额是否足够
		Testinfo__Room testinfo__Room;			// 每个考试信息
		for(int i=0;i<testinfo__RoomList.size();i++) {
			testinfo__Room = testinfo__RoomList.get(i);
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
			testinfo__RoomList.set(i, testinfo__Room);		// 将处理好的数据传回list
		}
		
		model.addAttribute("allTestinfo__Room", testinfo__RoomList);
		// 这个指令将转到本地文件层验证
		return "before/userSelectTestinfo";
	}

}
