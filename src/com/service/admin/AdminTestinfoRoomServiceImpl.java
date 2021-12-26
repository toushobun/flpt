package com.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminRoomDao;
import com.dao.AdminTestinfoRoomDao;
import com.entity.Room;
import com.entity.TestinfoRoom;

@Service("adminTestinfoRoomService")
@Transactional
public class AdminTestinfoRoomServiceImpl implements AdminTestinfoRoomService {

	@Autowired
	private AdminTestinfoRoomDao adminTestinfoRoomDao;

	@Autowired
	private AdminRoomDao adminRoomDao;

	@Override
	public String selectTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		List<TestinfoRoom> testinfoRoomList = adminTestinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoom);
		List<Room> notSelectedRoom = adminRoomDao.selectNotSelectedRoom(testinfoRoom.getTestinfo_id());
		model.addAttribute("testinfoRoom", new TestinfoRoom());
		model.addAttribute("testinfoRoomList", testinfoRoomList);
		model.addAttribute("notSelectedRoom", notSelectedRoom);
		return "admin/testinfoRoom/selectTestinfoRoom";
	}

	@Override
	public String toAddTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		List<Room> selectedRoomList = new ArrayList<Room>();
		Room roomToSelect = new Room();
		for (int i = 0; i < testinfoRoom.getRoom_ids().length; i++) {
			// 设置关联表里的room_id
			roomToSelect.setRoom_id(testinfoRoom.getRoom_ids()[i]);
			selectedRoomList.add(adminRoomDao.selectRoomByKwargs(roomToSelect).get(0));
		}
		model.addAttribute("testinfoRoom", testinfoRoom);
		model.addAttribute("selectedRoomList", selectedRoomList);
		return "admin/testinfoRoom/addTestinfoRoom";
	}

	@Override
	public String addTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		try {
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
	public String cancelRoom(TestinfoRoom testinfoRoom, Model model) {
		try {
			adminTestinfoRoomDao.deleteTestinfoRoomByTestinfoRoom_id(testinfoRoom.getTestinfoRoom_id());
			model.addAttribute("msg", "取消成功！");
			return "forward:/adminTestinfoRoom/selectTestinfoRoom?testinfo_id=" + testinfoRoom.getTestinfo_id();
		} catch (Exception e) {
			model.addAttribute("msg", "取消失败！已有考生报名此考场，请先删除对应报名信息！");
			return "forward:/adminTestinfoRoom/selectTestinfoRoom?testinfo_id=" + testinfoRoom.getTestinfo_id();
		}
	}

	@Override
	public String changeQuota(TestinfoRoom testinfoRoom, Model model) {
		try {
			adminTestinfoRoomDao.updateTestinfoRoom(testinfoRoom);
			model.addAttribute("msg", "修改成功！");
			return "forward:/adminTestinfoRoom/selectTestinfoRoom?testinfo_id=" + testinfoRoom.getTestinfo_id();
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "forward:/adminTestinfoRoom/selectTestinfoRoom?testinfo_id=" + testinfoRoom.getTestinfo_id();
		}
	}

}
