package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Test;
import com.service.admin.AdminTestService;

@Controller
@RequestMapping("/adminTest")
public class AdminTestController extends BaseAdminController {

	@Autowired
	AdminTestService adminTestService;

	@RequestMapping("/selectTest")
	public String selectTest(Model model) {
		return adminTestService.selectTest(model);
	}

	@RequestMapping("/toAddTest")
	public String toAddTest(Test test) {
		return "admin/test/addTest";
	}

	@RequestMapping("/addTest")
	public String addTest(Test test, Model model) {
		return adminTestService.addTest(test, model);
	}

	@RequestMapping("/deleteTest")
	public String deleteTest(Integer test_id, Model model) {
		return adminTestService.deleteTest(test_id, model);
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
	public String searchTest(Test test, Model model) {
		return adminTestService.searchTest(test, model);
	}

}
