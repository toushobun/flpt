package com.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.ReginfoDao;
import com.dao.RoomDao;
import com.dao.TestDao;
import com.dao.TestinfoDao;
import com.dao.TestinfoRoomDao;
import com.entity.Reginfo;
import com.entity.Room;
import com.entity.Test;
import com.entity.Testinfo;
import com.entity.TestinfoRoom;

@Service("adminTestinfoService")
@Transactional
public class AdminTestinfoServiceImpl implements AdminTestinfoService {

	@Autowired
	private TestinfoDao testinfoDao;

	@Autowired
	private TestinfoRoomDao testinfoRoomDao;

	@Autowired
	private TestDao testDao;

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private ReginfoDao reginfoDao;

	@Override
	public String selectTestinfo(Model model) {
		List<Testinfo> testinfoList = testinfoDao.selectTestinfoByKwargs(null);
		model.addAttribute("testinfo", new Testinfo());
		model.addAttribute("testinfoList", testinfoList);
		return "admin/testinfo/selectTestinfo";
	}

	@Override
	public String toAddTestinfo(TestinfoRoom testinfoRoom, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("testinfoRoom", testinfoRoom);
		model.addAttribute("testList", testDao.selectTestByKwargs(null));
		model.addAttribute("roomList", roomDao.selectRoomByKwargs(null));
		return "admin/testinfo/addTestinfo";
	}

	@Override
	public String toAddTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		Test testToSelect = new Test();
		testToSelect.setTest_id(testinfoRoom.getTest_id());
		Test test = testDao.selectTestByKwargs(testToSelect).get(0);
		if (test.getStatus() != 0) {
			model.addAttribute("msg", "该考试已发布！");
			return "forward:/adminTestinfo/toAddTestinfo";
		}
		List<Room> selectedRoomList = new ArrayList<Room>();
		Room roomToSelect = new Room();
		for (int i = 0; i < testinfoRoom.getRoom_ids().length; i++) {
			// 设置关联表里的room_id
			roomToSelect.setRoom_id(testinfoRoom.getRoom_ids()[i]);
			selectedRoomList.add(roomDao.selectRoomByKwargs(roomToSelect).get(0));
		}
		model.addAttribute("testinfoRoom", testinfoRoom);
		model.addAttribute("selectedRoomList", selectedRoomList);
		return "admin/testinfo/addTestinfoRoom";
	}

	@Override
	public String addTestinfo(TestinfoRoom testinfoRoom, Model model) {
		try {
			// 先将此考试添加到发布考试
			Testinfo testinfo = new Testinfo();
			testinfo.setTest_id(testinfoRoom.getTest_id());
			testinfo.setTest_time(testinfoRoom.getTest_time());
			testinfo.setRegist_start_time(testinfoRoom.getRegist_start_time());
			testinfo.setRegist_end_time(testinfoRoom.getRegist_end_time());
			testinfo.setTprice(testinfoRoom.getTprice());
			testinfoDao.addTestinfo(testinfo);

			// 再将此考试的status设为1
			Test testToUpdate = new Test();
			testToUpdate.setTest_id(testinfoRoom.getTest_id());
			testToUpdate.setStatus(1);
			testDao.updateTest(testToUpdate);

			// 再取得刚发布的testinfo_id，将此和考场绑定加入关联表
			Testinfo testinfoToSelect = new Testinfo();
			testinfoToSelect.setTest_id(testinfoRoom.getTest_id());
			Integer testinfo_id = testinfoDao.selectTestinfoByKwargs(testinfoToSelect).get(0).getTestinfo_id();
			testinfoRoom.setTestinfo_id(testinfo_id);
			for (int i = 0; i < testinfoRoom.getRoom_ids().length; i++) {
				// 设置关联表里的room_id
				testinfoRoom.setRoom_id(testinfoRoom.getRoom_ids()[i]);
				testinfoRoom.setRquota(testinfoRoom.getRoom_rquotas()[i]);
				testinfoRoomDao.addTestinfoRoom(testinfoRoom);
			}
			model.addAttribute("msg", "添加成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "添加失败！");
			return "forward:/adminTestinfo/selectTestinfo";
		}
	}

	@Override
	public String deleteTestinfo(Integer testinfo_id, Model model) {
		try {
			// 先取出所有该考试即将要删除的绑定的考场
			TestinfoRoom testinfoRoomToSelect = new TestinfoRoom();
			testinfoRoomToSelect.setTestinfo_id(testinfo_id);
			List<TestinfoRoom> testinfoRoomList = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToSelect);
			// 遍历查看该绑定信息是否被考生报名绑定
			Reginfo reginfoToSelect = new Reginfo();
			List<Reginfo> reginfoList = new ArrayList<Reginfo>();
			// 遍历绑定的所有考场
			for (int i = 0; i < testinfoRoomList.size(); i++) {
				reginfoToSelect.setTestinfoRoom_id(testinfoRoomList.get(i).getTestinfoRoom_id());
				reginfoList = reginfoDao.selectReginfoByKwargs(reginfoToSelect);
				// 先遍历删除所有准考证
				for (int j = 0; j < reginfoList.size(); j++) {
					reginfoDao.deleteReginfoByReginfo_id(reginfoList.get(j).getReginfo_id());
				}
				// 再删除对应考场
				testinfoRoomDao.deleteTestinfoRoomByTestinfoRoom_id(testinfoRoomList.get(i).getTestinfoRoom_id());
			}
			// 先得到该考试的id
			Testinfo testinfoToSelect = new Testinfo();
			testinfoToSelect.setTestinfo_id(testinfo_id);
			Integer test_id = testinfoDao.selectTestinfoByKwargs(testinfoToSelect).get(0).getTest_id();
			// 设置该考试的status为0
			Test testToUpdate = new Test();
			testToUpdate.setTest_id(test_id);
			testToUpdate.setStatus(1);
			testDao.updateTest(testToUpdate);
			// 最后删除考试信息
			testinfoDao.deleteTestinfoByTestinfo_id(testinfo_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！");
			return "forward:/adminTestinfo/selectTestinfo";
		}
	}

	@Override
	public String toUpdateTestinfo(Integer testinfo_id, Model model) {
		List<Test> testList = testDao.selectTestByKwargs(null);
		Testinfo testinfoToSelect = new Testinfo();
		testinfoToSelect.setTestinfo_id(testinfo_id);
		Testinfo testinfo = testinfoDao.selectTestinfoByKwargs(testinfoToSelect).get(0);
		model.addAttribute("testList", testList);
		model.addAttribute("testinfo", testinfo);
		return "admin/testinfo/updateTestinfo";
	}

	@Override
	public String updateTestinfo(Testinfo testinfo, Model model) {
		try {
			testinfoDao.updateTestinfo(testinfo);
			model.addAttribute("msg", "修改成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "admin/testinfo/updateTestinfo";
		}
	}

	@Override
	public String searchTestinfo(Testinfo testinfo, Model model) {
		List<Testinfo> testinfoList = testinfoDao.selectTestinfoFuzzily(testinfo);
		model.addAttribute("testinfo", testinfo);
		model.addAttribute("testinfoList", testinfoList);
		return "admin/testinfo/selectTestinfo";
	}

}
