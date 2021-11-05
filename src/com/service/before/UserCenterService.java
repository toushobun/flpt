package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Buser;

public interface UserCenterService {

	public String updatePwd(Buser buser, Model model, HttpSession session);
	public String deleteUserByUser_id(Integer id, Model model);
	
}
