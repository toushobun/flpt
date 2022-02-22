package com.service.user;

import org.springframework.ui.Model;

import com.entity.Notice;

public interface UserNoticeService {

	public String selectNotice(Model model); // 查询全部公告

	public String selectANotice(Notice notice, Model model); // 查询一个公告

}
