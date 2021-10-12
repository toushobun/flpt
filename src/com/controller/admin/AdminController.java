package com.controller.admin;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Auser;
import com.service.admin.AdminService;
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/admin")
	public String toLogin() {
		return "admin/login";
	}
	@RequestMapping("/admin/login")
	public String login(Auser auser, Model model, HttpSession session) {
		return adminService.login(auser, model, session);
	}
	@RequestMapping("/exit")
	public String exit(Auser auser, HttpSession session) {
		session.invalidate();
		return "admin/login";
	}

}
