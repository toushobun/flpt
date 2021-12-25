package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Notice;

public interface AdminNoticeService {

	public String selectNotice(Model model); // 查询全部公告

	public String addNotice(Notice notice, Model model); // 添加公告

	public String deleteNotice(Integer notice_id, Model model); // 通过id删除公告

	public String selectANotice(Integer notice_id, Model model); // 查询一个公告

}
