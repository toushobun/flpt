package com.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
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
	public String toLogin(User user) {
		return "user/login";
	}

	@RequestMapping("/user/login")
	public String login(User user, Model model, HttpSession session) {
		return userService.login(user, model, session);
	}

	@RequestMapping("/user/toRegister")
	public String toRegister(User user) {
		return "user/register";
	}

	@RequestMapping("/user/register")
	public String register(User user, HttpServletRequest request, Model model, HttpSession session, String code) {
		return userService.register(user, request, model, session, code);
	}

	@RequestMapping("/user/exit")
	public String exit(User user, Model model, HttpSession session) {
		model.addAttribute("msg", "µÇ³ö³É¹¦£¡");
		session.invalidate();
		return "user/index";
	}

}