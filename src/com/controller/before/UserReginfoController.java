package com.controller.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Reginfo;
import com.service.before.UserReginfoService;

@Controller
@RequestMapping("/userReginfo")
public class UserReginfoController extends BaseBeforeController {
	@Autowired
	private UserReginfoService userReginfoService;
	@RequestMapping("/userSelectTestinfo")
	public String userSelectTestinfo(HttpSession session) {
		return userReginfoService.userSelectTestinfo(session);
	}
	@RequestMapping("/userSelectTestinfoRoom")
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model) {
		return userReginfoService.userSelectTestinfoRoom(testinfo_id, model);
	}
	@RequestMapping("/userAddReginfo")
	public String userAddReginfo(Reginfo reginfo, Model model, HttpSession session) {
		return userReginfoService.userAddReginfo(reginfo, model, session);
	}
	@RequestMapping("/userSelectAReginfo")
	public String userSelectAReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.userSelectAReginfoByUser_idAndTestinfo_id(reginfo, model);
	}
}
