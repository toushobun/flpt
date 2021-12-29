package com.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Buser;
import com.entity.Notice;

public interface UserService {

	public String login(Buser buser, Model model, HttpSession session);

	public String register(Buser buser, HttpServletRequest request, Model model, HttpSession session, String code);

	public String userSelectNotice(Model model);

	public String userSelectANotice(Notice notice, Model model);

}