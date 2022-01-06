package com.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.User;

public interface UserService {

	public String login(User user, Model model, HttpSession session, String code);

	public String register(User user, HttpServletRequest request, Model model, HttpSession session, String code);

}