package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Reginfo;
import com.service.user.UserReginfoService;

@Controller
@RequestMapping("/userReginfo")
public class UserReginfoController extends BaseUserController {

	@Autowired
	UserReginfoService userReginfoService;

	@RequestMapping("/selectReginfo")
	public String selectReginfo(Integer user_id, Model model) {
		return userReginfoService.selectReginfo(user_id, model);
	}

	@RequestMapping("/addReginfo")
	public String addReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.addReginfo(reginfo, model);
	}

	@RequestMapping("/deleteReginfo")
	public String deleteReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.deleteReginfo(reginfo, model);
	}

	@RequestMapping("/selectAReginfo")
	public String selectAReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.selectAReginfo(reginfo, model);
	}

	@RequestMapping("/cancelReg")
	public String cancelReg(Reginfo reginfo, Model model) {
		return userReginfoService.cancelReg(reginfo, model);
	}

	@RequestMapping("/searchReginfo")
	public String searchReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.searchReginfo(reginfo, model);
	}

}
