package com.service.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.TestinfoRoomDao;
import com.entity.TestinfoRoom;
import com.util.MyUtil;

@Service("userTestinfoRoomService")
@Transactional
public class UserTestinfoRoomServiceImpl implements UserTestinfoRoomService {

	@Autowired
	private TestinfoRoomDao testinfoRoomDao;

	@Override
	public String selectTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		List<TestinfoRoom> testinfoRoomList = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoom);
		boolean ifInTime; // ②是否在报名时间内
		boolean ifHaveQuota; // ①名额是否足够
		for (int i = 0; i < testinfoRoomList.size(); i++) {
			testinfoRoom = testinfoRoomList.get(i);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			Date date1 = null;
			Date date2 = null;
			try {
				date1 = sf.parse(testinfoRoom.getRegist_start_time()); // 获取报名开始时间
				date2 = sf.parse(testinfoRoom.getRegist_end_time()); // 获取报名截止时间
			} catch (ParseException e) {
				// TODO Auto-generated catch block
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
			testinfoRoomList.set(i, testinfoRoom);
		}
		model.addAttribute("testinfoRoomList", testinfoRoomList);
		return "user/testinfoRoom/selectTestinfoRoom";
	}

}
