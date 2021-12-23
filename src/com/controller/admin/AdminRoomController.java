package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Room;
import com.service.admin.AdminRoomService;

@Controller
@RequestMapping("/adminRoom")
public class AdminRoomController extends BaseController {

	@Autowired
	private AdminRoomService adminRoomService;

	@RequestMapping("/selectRoom")
	public String selectRoom(Model model) {
		return adminRoomService.selectRoom(model);
	}

	@RequestMapping("/toAddRoom")
	// 需要传一个空的Room对象，不然前端显示的时候会报错
	public String toAddRoom(@ModelAttribute Room room) {
		return "admin/addRoom";
	}

	@RequestMapping("/addRoom")
	public String addRoom(Room room, Model model) {
		return adminRoomService.addRoom(room, model);
	}

	@RequestMapping("/deleteRoom")
	public String deleteRoom(Integer room_id, Model model) {
		return adminRoomService.deleteRoomByRoom_id(room_id, model);
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
	public String searchRoom(String keyWord, Model model) {
		return adminRoomService.searchRoom(keyWord, model);
	}

}
