package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Reginfo;
import com.service.user.UserReginfoService;

@Controller
@RequestMapping("/userReginfo")
public class UserReginfoController extends BaseUserController {

	@Autowired
	UserReginfoService userReginfoService;

	@RequestMapping("/addReginfo")
	public String addReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.addReginfo(reginfo, model);
	}

}
