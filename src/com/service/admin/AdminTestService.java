package com.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Test;

public interface AdminTestService {
	public String selectTest(Model model);		// ²éÑ¯È«²¿¿¼ÊÔ
	public String addTest(Test test, Model model, HttpSession session);		// Ìí¼Ó¿¼ÊÔ
	public String deleteTestByTest_id(Integer test_id, Model model, HttpSession session);		// Í¨¹ıidÉ¾³ı¿¼ÊÔ
	public String toUpdateTest(Integer test_id, Model model);		// Ç°ÍùĞŞ¸Ä¿¼ÊÔÒ³
	public String updateTest(Test test, Model model, HttpSession session);		// ĞŞ¸Ä¿¼ÊÔ
	public String searchTest(String keyWord, Model model);		// Ä£ºıËÑË÷
}
