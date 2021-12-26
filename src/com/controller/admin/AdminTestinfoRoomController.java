package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.TestinfoRoom;
import com.service.admin.AdminTestinfoRoomService;

@Controller
@RequestMapping("/adminTestinfoRoom")
public class AdminTestinfoRoomController extends BaseController {

	@Autowired
	AdminTestinfoRoomService adminTestinfoRoomService;

	@RequestMapping("/selectTestinfoRoom")
	public String selectTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		return adminTestinfoRoomService.selectTestinfoRoom(testinfoRoom, model);
	}

	@RequestMapping("/toAddTestinfoRoom")
	public String toAddTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		return adminTestinfoRoomService.toAddTestinfoRoom(testinfoRoom, model);
	}

	@RequestMapping("/addTestinfoRoom")
	public String addTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		return adminTestinfoRoomService.addTestinfoRoom(testinfoRoom, model);
	}

	@RequestMapping("/cancelRoom")
	public String cancelRoom(TestinfoRoom testinfoRoom, Model model) {
		return adminTestinfoRoomService.cancelRoom(testinfoRoom, model);
	}

	@RequestMapping("/changeQuota")
	public String changeQuota(TestinfoRoom testinfoRoom, Model model) {
		return adminTestinfoRoomService.changeQuota(testinfoRoom, model);
	}

}
