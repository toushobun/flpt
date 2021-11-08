package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Buser;

public interface UserService {
	
	public String login(Buser buser, Model model, HttpSession session, String code);		// 验证用户登录信息
	public String register(Buser buser, Model model, HttpSession session, String code);		// 注册
	public String userSelectNotice(Model model);		// 查询公告
	public String userSelectANoticeByNotice_id(Model model, Integer notice_id);		// 查询公告
	
}
