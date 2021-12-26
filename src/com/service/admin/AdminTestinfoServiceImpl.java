package com.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminRoomDao;
import com.dao.AdminTestDao;
import com.dao.AdminTestinfoDao;
import com.dao.AdminTestinfoRoomDao;
import com.entity.Room;
import com.entity.Test;
import com.entity.Testinfo;
import com.entity.TestinfoRoom;

@Service("adminTestinfoService")
@Transactional
public class AdminTestinfoServiceImpl implements AdminTestinfoService {

	@Autowired
	private AdminTestinfoDao adminTestinfoDao;

	@Autowired
	private AdminTestinfoRoomDao adminTestinfoRoomDao;

	@Autowired
	private AdminTestDao adminTestDao;

	@Autowired
	private AdminRoomDao adminRoomDao;

	@Override
	public String selectTestinfo(Model model) {
		List<Testinfo> testinfoList = adminTestinfoDao.selectTestinfoByKwargs(null);
		model.addAttribute("testinfo", new Testinfo());
		model.addAttribute("testinfoList", testinfoList);
		return "admin/testinfo/selectTestinfo";
	}

	@Override
	public String toAddTestinfo(Testinfo testinfo, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("testinfoRoom", new TestinfoRoom());
		model.addAttribute("testList", adminTestDao.selectTestByKwargs(null));
		model.addAttribute("roomList", adminRoomDao.selectRoomByKwargs(null));
		return "admin/testinfo/addTestinfo";
	}

	@Override
	public String toAddTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		Test testToSelect = new Test();
		testToSelect.setTest_id(testinfoRoom.getTest_id());
		Test test = adminTestDao.selectTestByKwargs(testToSelect).get(0);
		if (test.getStatus() != 0) {
			model.addAttribute("msg", "该考试已发布！");
			return "forward:/adminTestinfo/toAddTestinfo";
		}
		List<Room> selectedRoomList = new ArrayList<Room>();
		Room roomToSelect = new Room();
		for (int i = 0; i < testinfoRoom.getRoom_ids().length; i++) {
			// 设置关联表里的room_id
			roomToSelect.setRoom_id(testinfoRoom.getRoom_ids()[i]);
			selectedRoomList.add(adminRoomDao.selectRoomByKwargs(roomToSelect).get(0));
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
			adminTestinfoDao.addTestinfo(testinfo);

			// 再将此考试的status设为1
			Test testToUpdate = new Test();
			testToUpdate.setTest_id(testinfoRoom.getTest_id());
			testToUpdate.setStatus(1);
			adminTestDao.updateTest(testToUpdate);

			// 再取得刚发布的testinfo_id，将此和考场绑定加入关联表
			Testinfo testinfoToSelect = new Testinfo();
			testinfoToSelect.setTest_id(testinfoRoom.getTest_id());
			Integer testinfo_id = adminTestinfoDao.selectTestinfoByKwargs(testinfoToSelect).get(0).getTestinfo_id();
			testinfoRoom.setTestinfo_id(testinfo_id);
			for (int i = 0; i < testinfoRoom.getRoom_ids().length; i++) {
				// 设置关联表里的room_id
				testinfoRoom.setRoom_id(testinfoRoom.getRoom_ids()[i]);
				testinfoRoom.setRquota(testinfoRoom.getRoom_rquotas()[i]);
				adminTestinfoRoomDao.addTestinfoRoom(testinfoRoom);
			}
			model.addAttribute("msg", "添加成功！");
			return "forward:/adminTestinfoRoom/selectTestinfoRoom?testinfo_id=" + testinfoRoom.getTestinfo_id();
		} catch (Exception e) {
			model.addAttribute("msg", "添加失败！");
			return "forward:/adminTestinfoRoom/selectTestinfoRoom?testinfo_id=" + testinfoRoom.getTestinfo_id();
		}
	}

	@Override
	public String deleteTestinfo(Integer testinfo_id, Model model) {
		try {
			adminTestinfoDao.deleteTestinfoByTestinfo_id(testinfo_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！该考试已发布考场，请先删除对应考场！");
			return "forward:/adminTestinfo/selectTestinfo";
		}
	}

	@Override
	public String toUpdateTestinfo(Integer testinfo_id, Model model) {
		List<Test> testList = adminTestDao.selectTestByKwargs(null);
		Testinfo testinfoToSelect = new Testinfo();
		testinfoToSelect.setTestinfo_id(testinfo_id);
		Testinfo testinfo = adminTestinfoDao.selectTestinfoByKwargs(testinfoToSelect).get(0);
		model.addAttribute("testList", testList);
		model.addAttribute("testinfo", testinfo);
		return "admin/testinfo/updateTestinfo";
	}

	@Override
	public String updateTestinfo(Testinfo testinfo, Model model) {
		try {
			adminTestinfoDao.updateTestinfo(testinfo);
			model.addAttribute("msg", "修改成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "admin/testinfo/updateTestinfo";
		}
	}

	@Override
	public String searchTestinfo(Testinfo testinfo, Model model) {
		List<Testinfo> testinfoList = adminTestinfoDao.selectTestinfoFuzzily(testinfo);
		model.addAttribute("testinfo", testinfo);
		model.addAttribute("testinfoList", testinfoList);
		return "admin/testinfo/selectTestinfo";
	}

}
