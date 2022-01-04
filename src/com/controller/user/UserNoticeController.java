package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Notice;
import com.service.user.UserNoticeService;

@Controller
@RequestMapping("/userNotice")
public class UserNoticeController {

	@Autowired
	UserNoticeService userNoticeService;

	@RequestMapping("/selectNotice")
	public String selectNotice(Model model) {
		return userNoticeService.selectNotice(model);
	}

	@RequestMapping("/selectANotice")
	public String selectANotice(Notice notice, Model model) {
		return userNoticeService.selectANotice(notice, model);
	}

}
