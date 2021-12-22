package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Testinfo;
import com.entity.Testinfo__room;
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

	@RequestMapping("/toAddTestinfoRoom")
	public String toAddTestinfoRoom(Testinfo testinfo, Model model) {
		return adminTestinfoService.toAddTestinfoRoom(testinfo, model);
	}

	@RequestMapping("/toAddTestinfoNewRoom")
	public String toAddTestinfoNewRoom(Testinfo testinfo, Model model) {
		return adminTestinfoService.toAddTestinfoNewRoom(testinfo, model);
	}

	@RequestMapping("/addTestinfo")
	public String addTestinfo(Testinfo testinfo, Model model) {
		return adminTestinfoService.addTestinfo(testinfo, model);
	}

	@RequestMapping("/addTestinfoRoom")
	public String addTestinfoRoom(Testinfo testinfo, Model model) {
		return adminTestinfoService.addTestinfoRoom(testinfo, model);
	}

	@RequestMapping("/deleteTestinfo")
	public String deleteTestinfo(Integer testinfo_id, Model model) {
		return adminTestinfoService.deleteTestinfoByTestinfo_id(testinfo_id, model);
	}

	@RequestMapping("/toUpdateTestinfo")
	public String toUpdateTestinfo(Integer testinfo_id, Model model) {
		return adminTestinfoService.toUpdateTestinfo(testinfo_id, model);
	}

	@RequestMapping("/updateTestinfo")
	public String updateTestinfo(Testinfo testinfo, Model model) {
		return adminTestinfoService.updateTestinfo(testinfo, model);
	}

	@RequestMapping("/selectTestinfoRoom")
	public String selectTestinfoRoom(Integer testinfo_id, Model model) {
		return adminTestinfoService.selectTestinfoRoom(testinfo_id, model);
	}

	@RequestMapping("/updateRoomQuota")
	public String updateRoomQuota(Testinfo__room testinfo__room, Model model) {
		return adminTestinfoService.updateRoomQuota(testinfo__room, model);
	}

	@RequestMapping("/cancelRoom")
	public String cancelRoom(Testinfo__room testinfo__room, Model model) {
		return adminTestinfoService.cancelRoom(testinfo__room, model);
	}

	@RequestMapping("/searchTestinfo")
	public String searchTestinfo(String keyWord, Model model) {
		return adminTestinfoService.searchTestinfo(keyWord, model);
	}

}
