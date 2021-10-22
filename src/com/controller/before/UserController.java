package com.controller.before;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Buser;
import com.service.before.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/before")
	public String before() {
		return "before/index";
	}
	@RequestMapping("/before/toLogin")
	public String toLogin(Buser buser) {
		return "before/login";
	}
	@RequestMapping("/before/login")
	public String login(Buser buser, Model model, HttpSession session, String code) {
		return userService.login(buser, model, session, code);
	}
	@RequestMapping("/userSelectANotice")
	public String userSelectANotice(Model model, Integer notice_id) {
		return userService.userSelectANoticeByNotice_id(model, notice_id);
	}
	@RequestMapping("/toRegister")
	public String toRegister(Buser buser) {
		return "before/register";
	}
	@RequestMapping("/register")
	public String register(Buser buser, Model model, HttpSession session, String code) {
		return userService.register(buser, model, session, code);
	}
	@RequestMapping("/before/exit")
	public String exit(Buser buser, HttpSession session) {
		session.invalidate();
		return "forward:/before";
	}
	@RequestMapping("userSelectNotice")
	public String userSelectNotice(Model model) {
		return userService.userSelectNotice(model);
	}
}
