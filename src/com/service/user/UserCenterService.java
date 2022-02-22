package com.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.User;

public interface UserCenterService {

	public String deleteUser(Integer user_id, Model model, HttpSession session);

	public String updateIdphoto(User user, HttpServletRequest request, Model model, HttpSession session);

	public String updatePwd(User user, Model model, HttpSession session);

}