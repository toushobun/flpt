package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.admin.AdminReginfoService;

@Controller
@RequestMapping("/adminReginfo")
public class AdminReginfoController extends BaseController {
	
	@Autowired
	private AdminReginfoService adminReginfoService;

	@RequestMapping("selectReginfo")
	public String selectReginfo(Model model) {
		return adminReginfoService.selectReginfo(model);
	}

	@RequestMapping("deleteReginfo")
	public String deleteReginfo(Integer reginfo_id, Model model) {
		return adminReginfoService.deleteReginfo(reginfo_id, model);
	}
	
}
