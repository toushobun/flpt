package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Notice;
import com.service.admin.AdminNoticeService;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController {
	
	@Autowired
	private AdminNoticeService adminNoticeService;
	
	@RequestMapping("/toAddNotice")
	public String toAddNotice(Model model) {
		model.addAttribute("notice", new Notice());
		return "admin/addNotice";
	}
	@RequestMapping("/addNotice")
	public String addNotice(@ModelAttribute Notice notice, Model model) {
		return adminNoticeService.addNotice(model, notice);
	}
	@RequestMapping("/selectANotice")
	public String selectANotice(Model model, Integer notice_id) {
		return adminNoticeService.selectANoticeByNotice_id(model, notice_id);
	}
	@RequestMapping("/deleteNotice")
	public String deleteNotice(Model model, Integer notice_id) {
		return adminNoticeService.deleteNoticeByNotice_id(model, notice_id);
	}
	@RequestMapping("/selectNotice")
	public String selectNotice(Model model) {
		return adminNoticeService.selectNotice(model);
	}
	
}
