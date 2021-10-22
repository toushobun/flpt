package com.service.before;

import org.springframework.ui.Model;

public interface UserReginfoService {
	
	public String userSelectTestinfo(Model model);
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model);
	
}
