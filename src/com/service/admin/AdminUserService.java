package com.service.admin;

import org.springframework.ui.Model;

import com.entity.User;

public interface AdminUserService {

	public String selectUser(Model model); // 查询全部考生

	public String deleteUser(Integer user_id, Model model); // 通过id删除考生

	public String searchUser(User user, Model model); // 模糊搜索

}
