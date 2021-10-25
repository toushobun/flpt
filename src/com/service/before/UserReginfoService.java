package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Reginfo;

public interface UserReginfoService {
	
	public String userSelectTestinfo(HttpSession session);
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model);
	public String userAddReginfo(Reginfo reginfo, Model model, HttpSession session);
	
}
