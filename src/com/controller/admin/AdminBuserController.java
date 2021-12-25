package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Buser;
import com.service.admin.AdminBuserService;

@Controller
@RequestMapping("/adminBuser")
public class AdminBuserController extends BaseController {

	@Autowired
	AdminBuserService adminBuserService;

	@RequestMapping("/selectBuser")
	public String selectBuser(Model model) {
		return adminBuserService.selectBuser(model);
	}

	@RequestMapping("/deleteBuser")
	public String deleteBuser(Integer user_id, Model model) {
		return adminBuserService.deleteBuser(user_id, model);
	}

	@RequestMapping("/searchBuser")
	public String searchBuser(Buser buser, Model model) {
		return adminBuserService.searchBuser(buser, model);
	}

}
