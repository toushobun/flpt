package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Notice;

public interface AdminNoticeService {
	
	public String addNotice(Model model, Notice notice);		// 添加新公告
	public String deleteNoticeByNotice_id(Model model, Integer notice_id);		// 通过id删除一个公告
	public String selectANoticeByNotice_id(Model model, Integer notice_id);		// 查询某个公告的详细信息
	public String selectNotice(Model model);		// 查询全部公告
	
}
