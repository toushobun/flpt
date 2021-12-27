package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Room;
import com.service.admin.AdminRoomService;

@Controller
@RequestMapping("/adminRoom")
public class AdminRoomController extends BaseAdminController {

	@Autowired
	AdminRoomService adminRoomService;

	@RequestMapping("/selectRoom")
	public String selectRoom(Model model) {
		return adminRoomService.selectRoom(model);
	}

	@RequestMapping("/toAddRoom")
	public String toAddRoom(Room room) {
		return "admin/room/addRoom";
	}

	@RequestMapping("/addRoom")
	public String addRoom(Room room, Model model) {
		return adminRoomService.addRoom(room, model);
	}

	@RequestMapping("/deleteRoom")
	public String deleteRoom(Integer room_id, Model model) {
		return adminRoomService.deleteRoom(room_id, model);
	}

	@RequestMapping("/toUpdateRoom")
	public String toUpdateRoom(Integer room_id, Model model) {
		return adminRoomService.toUpdateRoom(room_id, model);
	}

	@RequestMapping("/updateRoom")
	public String updateRoom(Room room, Model model) {
		return adminRoomService.updateRoom(room, model);
	}

	@RequestMapping("/searchRoom")
	public String searchRoom(Room room, Model model) {
		return adminRoomService.searchRoom(room, model);
	}

}
