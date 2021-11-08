package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.admin.AdminUserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController {
	
	@Autowired
	private AdminUserService adminUserService;
	
	@RequestMapping("/selectUser")
	public String selectUser(Model model) {
		return adminUserService.selectUser(model);
	}
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer user_id, Model model) {
		return adminUserService.deleteUserByUser_id(user_id, model);
	}
	@RequestMapping("/searchUser")
	public String searchUser(String keyWord, Model model) {
		return adminUserService.searchUser(keyWord, model);
	}
	
}
