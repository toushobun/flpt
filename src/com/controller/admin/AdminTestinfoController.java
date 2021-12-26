package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Testinfo;
import com.entity.TestinfoRoom;
import com.service.admin.AdminTestinfoService;

@Controller
@RequestMapping("/adminTestinfo")
public class AdminTestinfoController extends BaseController {

	@Autowired
	AdminTestinfoService adminTestinfoService;

	@RequestMapping("/selectTestinfo")
	public String selectTestinfo(Model model) {
		return adminTestinfoService.selectTestinfo(model);
	}

	@RequestMapping("/toAddTestinfo")
	public String toAddTestinfo(Testinfo testinfo, Model model) {
		return adminTestinfoService.toAddTestinfo(testinfo, model);
	}

	@RequestMapping("/toAddTestinfoRoom")
	public String toAddTestinfoRoom(TestinfoRoom testinfoRoom, Model model) {
		return adminTestinfoService.toAddTestinfoRoom(testinfoRoom, model);
	}

	@RequestMapping("/addTestinfo")
	public String addTestinfo(TestinfoRoom testinfoRoom, Model model) {
		return adminTestinfoService.addTestinfo(testinfoRoom, model);
	}

	@RequestMapping("/deleteTestinfo")
	public String deleteTestinfo(Integer testinfo_id, Model model) {
		return adminTestinfoService.deleteTestinfo(testinfo_id, model);
	}

	@RequestMapping("/toUpdateTestinfo")
	public String toUpdateTestinfo(Integer testinfo_id, Model model) {
		return adminTestinfoService.toUpdateTestinfo(testinfo_id, model);
	}

	@RequestMapping("/updateTestinfo")
	public String updateTestinfo(Testinfo testinfo, Model model) {
		return adminTestinfoService.updateTestinfo(testinfo, model);
	}

	@RequestMapping("/searchTestinfo")
	public String searchTestinfo(Testinfo testinfo, Model model) {
		return adminTestinfoService.searchTestinfo(testinfo, model);
	}

}
