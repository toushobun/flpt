package com.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Testinfo;
import com.entity.Testinfo__Room;
import com.service.admin.AdminTestinfoService;
@Controller
@RequestMapping("/adminTestinfo")
public class AdminTestinfoController extends BaseController {
	@Autowired
	private AdminTestinfoService adminTestinfoService;
	@RequestMapping("/selectTestinfo")
	public String selectTestinfo(HttpSession session) {
		return adminTestinfoService.selectTestinfo(session);
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
	public String addTestinfo(Testinfo testinfo, Model model, HttpSession session) {
		return adminTestinfoService.addTestinfo(testinfo, model, session);
	}
	@RequestMapping("/addTestinfoRoom")
	public String addTestinfoRoom(Testinfo testinfo, Model model, HttpSession session) {
		return adminTestinfoService.addTestinfoRoom(testinfo, model, session);
	}
	@RequestMapping("/deleteTestinfo")
	public String deleteTestinfo(Integer id, Model model, HttpSession session) {
		return adminTestinfoService.deleteTestinfoById(id, model, session);
	}
	@RequestMapping("/toUpdateTestinfo")
	public String toUpdateTestinfo(Integer id, Model model) {
		return adminTestinfoService.toUpdateTestinfo(id, model);
	}
	@RequestMapping("/updateTestinfo")
	public String updateTestinfo(Testinfo testinfo, Model model, HttpSession session) {
		return adminTestinfoService.updateTestinfo(testinfo, model, session);
	}
	@RequestMapping("/selectTestinfoRoom")
	public String selectTestinfoRoom(Integer testinfo_id, Model model, HttpSession session) {
		return adminTestinfoService.selectTestinfoRoom(testinfo_id, model, session);
	}
	@RequestMapping("/updateRoomQuota")
	public String updateRoomQuota(Testinfo__Room testinfo__Room, Model model, HttpSession session) {
		return adminTestinfoService.updateRoomQuota(testinfo__Room, model, session);
	}
	@RequestMapping("/cancelRoom")
	public String cancelRoom(Testinfo__Room testinfo__Room, Model model, HttpSession session) {
		return adminTestinfoService.cancelRoom(testinfo__Room, model, session);
	}
	@RequestMapping("/searchTestinfo")
	public String searchTestinfo(String keyWord, HttpSession session) {
		return adminTestinfoService.searchTestinfo(keyWord, session);
	}
}
