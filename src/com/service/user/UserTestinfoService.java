package com.service.user;

import org.springframework.ui.Model;

import com.entity.Testinfo;

public interface UserTestinfoService {

	public String selectTestinfo(Integer user_id, Model model); // 查询全部考试信息

	public String searchTestinfo(Testinfo testinfo, Model model); // 模糊搜索

}
