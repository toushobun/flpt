package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Test;

public interface AdminTestService {

	public String selectTest(Model model); // ²éÑ¯È«²¿¿¼ÊÔ

	public String addTest(Test test, Model model); // Ìí¼Ó¿¼ÊÔ

	public String deleteTest(Integer test_id, Model model); // Í¨¹ıidÉ¾³ı¿¼ÊÔ

	public String toUpdateTest(Integer test_id, Model model); // Ç°ÍùĞŞ¸Ä¿¼ÊÔÒ³

	public String updateTest(Test test, Model model); // ĞŞ¸Ä¿¼ÊÔ

	public String searchTest(Test test, Model model); // Ä£ºıËÑË÷

}
