package com.service.user;

import org.springframework.ui.Model;

import com.entity.Reginfo;

public interface UserReginfoService {

	public String addReginfo(Reginfo reginfo, Model model); // 查询全部考试信息

	public String selectAReginfo(Reginfo reginfo, Model model); // 查询一个准考证

}
