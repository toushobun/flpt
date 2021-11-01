package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Reginfo;

public interface UserReginfoService {
	
	public String userSelectTestinfo(HttpSession session);
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model);
	public String userAddReginfo(Reginfo reginfo, Model model, HttpSession session);
	public String userSelectAReginfoByUser_idAndTestinfo_id(Reginfo reginfo, Model model);
	public String userToPay(Reginfo reginfo, Model model);
	public String userPay(Integer reginfo_id, Model model);
	public String userCancelReginfo(Integer reginfo_id, Model model);
	
}
