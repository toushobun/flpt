package com.service.admin;

import org.springframework.ui.Model;

public interface AdminUserService {
	
	public String selectUser(Model model);		// 查询全部考生
	public String deleteUserByUser_id(Integer buser_id, Model model);		// 通过id删除考生
	public String searchUser(String keyWord, Model model);		// 模糊查询
	
}
