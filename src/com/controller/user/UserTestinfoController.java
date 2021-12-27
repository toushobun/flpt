package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Testinfo;
import com.service.user.UserTestinfoService;

@Controller
@RequestMapping("/userTestinfo")
public class UserTestinfoController extends BaseUserController {

	@Autowired
	UserTestinfoService userTestinfoService;

	@RequestMapping("/selectTestinfo")
	public String selectTestinfo(Model model) {
		return userTestinfoService.selectTestinfo(model);
	}

	@RequestMapping("/searchTestinfo")
	public String searchTestinfo(Testinfo testinfo, Model model) {
		return userTestinfoService.searchTestinfo(testinfo, model);
	}

}
