package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Testinfo__room;
import com.service.admin.AdminTestinfoRoomService;

@Controller
@RequestMapping("/adminTestinfoRoom")
public class AdminTestinfoRoomController extends BaseController {

	@Autowired
	AdminTestinfoRoomService adminTestinfoRoomService;

	@RequestMapping("/selectTestinfoRoom")
	public String selectTestinfoRoom(Testinfo__room testinfo__room, Model model) {
		return adminTestinfoRoomService.selectTestinfoRoom(testinfo__room, model);
	}
}
