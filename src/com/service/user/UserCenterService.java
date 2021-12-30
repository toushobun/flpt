package com.service.user;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.User;

public interface UserCenterService {

	public String toUpdateUidphoto(Integer user_id, Model model);

	public String updateUidphoto(User user, Model model);

	public String toUpdateUpwd(Integer user_id, Model model);

	public String updateUpwd(User user, Model model);

	public String deleteUser(Integer user_id, Model model, HttpSession session);

}