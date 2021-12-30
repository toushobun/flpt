package com.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Buser;
import com.service.user.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public String user() {
		return "user/index";
	}

	@RequestMapping("/user/toLogin")
	public String toLogin(Buser buser) {
		return "user/login";
	}

	@RequestMapping("/user/login")
	public String login(Buser buser, Model model, HttpSession session) {
		return userService.login(buser, model, session);
	}

	@RequestMapping("/user/toRegister")
	public String toRegister(Buser buser) {
		return "user/register";
	}

	@RequestMapping("/user/register")
	public String register(Buser buser, HttpServletRequest request, Model model, HttpSession session, String code) {
		return userService.register(buser, request, model, session, code);
	}

	@RequestMapping("/user/exit")
	public String exit(Buser buser, Model model, HttpSession session) {
		model.addAttribute("msg", "µÇ³ö³É¹¦£¡");
		session.invalidate();
		return "user/index";
	}

}