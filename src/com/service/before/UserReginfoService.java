package com.service.before;

import org.springframework.ui.Model;

import com.entity.Reginfo;

public interface UserReginfoService {
	
	public String userSelectTestinfo(Model model);
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model);
	public String userAddReginfo(Reginfo reginfo, Model model);
	
}
