package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Test;
import com.service.admin.AdminTestService;

@Controller
@RequestMapping("/adminTest")
public class AdminTestController extends BaseController {

	@Autowired
	AdminTestService adminTestService;

	@RequestMapping("/selectTest")
	public String selectTest(Model model) {
		return adminTestService.selectTest(model);
	}

	@RequestMapping("/toAddTest")
	// 需要传一个空的Test对象，不然前端显示的时候会报错
	public String toAddTest(@ModelAttribute Test test) {
		return "admin/addTest";
	}

	@RequestMapping("/addTest")
	public String addTest(Test test, Model model) {
		return adminTestService.addTest(test, model);
	}

	@RequestMapping("/deleteTest")
	public String deleteTest(Integer test_id, Model model) {
		return adminTestService.deleteTestByTest_id(test_id, model);
	}

	@RequestMapping("/toUpdateTest")
	public String toUpdateTest(Integer test_id, Model model) {
		return adminTestService.toUpdateTest(test_id, model);
	}

	@RequestMapping("/updateTest")
	public String updateTest(Test test, Model model) {
		return adminTestService.updateTest(test, model);
	}

	@RequestMapping("/searchTest")
	public String searchTest(String keyWord, Model model) {
		return adminTestService.searchTest(keyWord, model);
	}
	
}
