package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.TestinfoRoom;
import com.service.user.UserTestinfoRoomService;

@Controller
@RequestMapping("/userTestinfoRoom")
public class UserTestinfoRoomController extends BaseUserController {

	@Autowired
	UserTestinfoRoomService userTestinfoRoomService;

	@RequestMapping("/selectTestinfoRoom")
	public String selectTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		return userTestinfoRoomService.selectTestinfoRoom(testinfoRoom, model);
	}

}
