package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Notice;
import com.service.admin.AdminNoticeService;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseAdminController {

	@Autowired
	AdminNoticeService adminNoticeService;

	@RequestMapping("/selectNotice")
	public String selectNotice(Model model) {
		return adminNoticeService.selectNotice(model);
	}

	@RequestMapping("/toAddNotice")
	public String toAddNotice(Notice notice) {
		return "admin/notice/addNotice";
	}

	@RequestMapping("/addNotice")
	public String addNotice(Notice notice, Model model) {
		return adminNoticeService.addNotice(notice, model);
	}

	@RequestMapping("/deleteNotice")
	public String deleteNotice(Integer notice_id, Model model) {
		return adminNoticeService.deleteNotice(notice_id, model);
	}

	@RequestMapping("/selectANotice")
	public String selectANotice(Notice notice, Model model) {
		return adminNoticeService.selectANotice(notice, model);
	}

}
