package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Testinfo;
import com.service.admin.AdminTestinfoService;
@Controller
@RequestMapping("/adminTestinfo")
public class AdminTestinfoController extends BaseController {
	@Autowired
	private AdminTestinfoService adminTestinfoService;
	@RequestMapping("/selectTestinfo")
	public String selectTestinfo(Model model) {
		return adminTestinfoService.selectTestinfo(model);
	}
	@RequestMapping("/toAddTestinfo")
	// 需要传一个空的Testinfo对象，不然前端显示的时候会报错
	public String toAddTestinfo(Model model) {
		return adminTestinfoService.toAddTestinfo(model);
	}
	@RequestMapping("/toAddTestinfoAboutRoom")
	public String toAddTestinfoAboutRoom(Testinfo testinfo, Model model) {
		return adminTestinfoService.toAddTestinfoAboutRoom(testinfo, model);
	}
	@RequestMapping("/addTestinfo")
	public String addTestinfo(Testinfo testinfo, Model model) {
		return adminTestinfoService.addTestinfo(testinfo, model);
	}
	@RequestMapping("/deleteTestinfo")
	public String deleteTestinfo(Integer id, Model model) {
		return adminTestinfoService.deleteTestinfoById(id, model);
	}
	@RequestMapping("/toUpdateTestinfo")
	public String toUpdateTestinfo(Integer id, Model model) {
		return adminTestinfoService.toUpdateTestinfo(id, model);
	}
	@RequestMapping("/updateTestinfo")
	public String updateTestinfo(Testinfo testinfo, Model model) {
		return adminTestinfoService.updateTestinfo(testinfo, model);
	}
	@RequestMapping("/selectTestinfoRoom")
	public String selectTestinfoRoom(Integer id, Model model) {
		return adminTestinfoService.selectTestinfoRoomByTestinfo_id(id, model);
	}
}
