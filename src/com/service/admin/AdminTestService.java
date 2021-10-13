package com.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Test;

public interface AdminTestService {
	public String selectTest(Model model);		// 查询全部考试
	public String addTest(Test test, Model model, HttpSession session);		// 添加考试
	public String deleteTestById(Integer id, Model model, HttpSession session);		// 通过id删除考试
	public String toUpdateTest(Integer id, Model model);		// 前往修改考试页
	public String updateTest(Test test, Model model, HttpSession session);		// 修改考试
	public String searchTest(String keyWord, Model model);		// 模糊搜索
}
