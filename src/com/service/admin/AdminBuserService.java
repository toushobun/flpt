package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Buser;

public interface AdminBuserService {

	public String selectBuser(Model model); // 查询全部考生

	public String deleteBuser(Integer user_id, Model model); // 通过id删除考生

	public String searchBuser(Buser buser, Model model); // 模糊搜索

}
