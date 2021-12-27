package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminRoomDao;
import com.entity.Room;

@Service("adminRoomService")
@Transactional
public class AdminRoomServiceImpl implements AdminRoomService {

	@Autowired
	private AdminRoomDao adminRoomDao;

	@Override
	public String selectRoom(Model model) {
		List<Room> roomList = adminRoomDao.selectRoomByKwargs(null);
		model.addAttribute("room", new Room());
		model.addAttribute("roomList", roomList);
		return "admin/room/selectRoom";
	}

	@Override
	public String addRoom(Room room, Model model) {
		try {
			Room roomToSelect = new Room();
			roomToSelect.setRname(room.getRname());
			List<Room> roomList = adminRoomDao.selectRepeatedRoom(roomToSelect);
			if (roomList.size() > 0) {
				model.addAttribute("msg", "添加失败！该考场已存在！");
				return "admin/room/addRoom";
			}
			adminRoomDao.addRoom(room);
			model.addAttribute("msg", "添加成功！");
			return "forward:/adminRoom/selectRoom";
		} catch (Exception e) {
			model.addAttribute("msg", "添加失败！");
			return "admin/room/addRoom";
		}
	}

	@Override
	public String deleteRoom(Integer room_id, Model model) {
		// TODO 删除考场前确认至少要留一个考场
		try {
			adminRoomDao.deleteRoomByRoom_id(room_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminRoom/selectRoom";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！该考场已发布！请先删除对应发布的考试！");
			return "forward:/adminRoom/selectRoom";
		}
	}

	@Override
	public String toUpdateRoom(Integer room_id, Model model) {
		Room roomToSelect = new Room();
		roomToSelect.setRoom_id(room_id);
		Room room = adminRoomDao.selectRoomByKwargs(roomToSelect).get(0);
		model.addAttribute("room", room);
		return "admin/room/updateRoom";
	}

	@Override
	public String updateRoom(Room room, Model model) {
		try {
			Room roomToSelect = new Room();
			roomToSelect.setRoom_id(room.getRoom_id());
			roomToSelect.setRname(room.getRname());
			List<Room> roomList = adminRoomDao.selectRepeatedRoom(roomToSelect);
			if (roomList.size() > 0) {
				model.addAttribute("msg", "修改失败！该考场已存在！");
				return "admin/room/updateRoom";
			}
			adminRoomDao.updateRoom(room);
			model.addAttribute("msg", "修改成功！");
			return "forward:/adminRoom/selectRoom";
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "admin/room/updateRoom";
		}
	}

	@Override
	public String searchRoom(Room room, Model model) {
		List<Room> roomList = adminRoomDao.selectRoomFuzzily(room);
		model.addAttribute("room", room);
		model.addAttribute("roomList", roomList);
		return "admin/room/selectRoom";
	}

}
