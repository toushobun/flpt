package com.service.user;

import java.sql.Timestamp;
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

@Service("userTestinfoRoomService")
@Transactional
public class UserTestinfoRoomServiceImpl implements UserTestinfoRoomService {

	@Autowired
	private TestinfoRoomDao testinfoRoomDao;

	@Autowired
	private ReginfoDao reginfoDao;

	@Override
	public String selectTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		// TODO 先查询报名该考试的所有准考证，如果状态为0且报名提交时间超过24小时，将该准考证状态设置为3，且对应考场名额加一
		Integer testinfo_id = testinfoRoom.getTestinfo_id();
		TestinfoRoom testinfoRoomToSelect = new TestinfoRoom();
		testinfoRoomToSelect.setTestinfo_id(testinfo_id);
		List<TestinfoRoom> testinfoRoomList = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToSelect);
		List<Reginfo> reginfoList = new ArrayList<Reginfo>();
		// 先遍历查询所有的绑定信息，同时根据绑定信息id查询准考证，将准考证加入准考证列表
		for (int i = 0; i < testinfoRoomList.size(); i++) {
			Integer testinfoRoom_id = testinfoRoomList.get(i).getTestinfoRoom_id();
			Reginfo reginfoToSelect = new Reginfo();
			reginfoToSelect.setTestinfoRoom_id(testinfoRoom_id);
			List<Reginfo> reginfoBuff = reginfoDao.selectReginfoByKwargs(reginfoToSelect);
			if (reginfoBuff.size() > 0) {
				reginfoList.add(reginfoBuff.get(0));
			}
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
		// 遍历该考试的每个准考证的时间
		for (int i = 0; i < reginfoList.size(); i++) {
			try {
				Integer status = reginfoList.get(i).getStatus();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				long time2 = new Timestamp(System.currentTimeMillis()).getTime();
				long time1 = simpleDateFormat.parse(reginfoList.get(i).getSubmit_time()).getTime();
				// 如果状态为0且时间超过24小时
				if (status == 0 && (time2 - time1) / 60 / 60 / 24 / 1000 >= 1) {
					// 先更新准考证状态
					Reginfo reginfoToUpdate = reginfoList.get(i);
					reginfoToUpdate.setStatus(3);
					reginfoDao.updateReginfo(reginfoToUpdate);
					// 再更新对应考场名额
					TestinfoRoom testinfoRoomToUpdate = new TestinfoRoom();
					testinfoRoomToUpdate.setTestinfoRoom_id(reginfoList.get(i).getTestinfoRoom_id());
					testinfoRoomToUpdate.setRquota(
							testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToUpdate).get(0).getRquota() + 1);
					testinfoRoomDao.updateTestinfoRoom(testinfoRoomToUpdate);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		// 开始对报名信息状态进行判断
		testinfoRoomList = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoom);
		boolean ifInTime; // ②是否在报名时间内
		boolean ifHaveQuota; // ①名额是否足够
		for (int i = 0; i < testinfoRoomList.size(); i++) {
			testinfoRoom = testinfoRoomList.get(i);
			Date date1 = null;
			Date date2 = null;
			try {
				date1 = sf.parse(testinfoRoom.getRegist_start_time()); // 获取报名开始时间
				date2 = sf.parse(testinfoRoom.getRegist_end_time()); // 获取报名截止时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date dateNow = new Date(); // 获取当前系统时间
			ifInTime = MyUtil.isInTime(dateNow, date1, date2); // 判断是否在报名时间内
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
