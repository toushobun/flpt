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
	public String deleteReginfo(Integer reginfo_id, Model model) {
		return userReginfoService.deleteReginfo(reginfo_id, model);
	}

	@RequestMapping("/toChangeRoom")
	public String toChangeRoom(Integer reginfo_id, Model model) {
		return userReginfoService.toChangeRoom(reginfo_id, model);
	}

	@RequestMapping("/changeRoom")
	public String changeRoom(Reginfo reginfo, Model model) {
		return userReginfoService.changeRoom(reginfo, model);
	}

	@RequestMapping("/cancelReg")
	public String cancelReg(Integer reginfo_id, Model model) {
		return userReginfoService.cancelReg(reginfo_id, model);
	}

	@RequestMapping("/selectAReginfo")
	public String selectAReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.selectAReginfo(reginfo, model);
	}

	@RequestMapping("/searchReginfo")
	public String searchReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.searchReginfo(reginfo, model);
	}

	@RequestMapping("/toPay")
	public String toPay(Integer reginfo_id, Model model) {
		return userReginfoService.toPay(reginfo_id, model);
	}

	@RequestMapping("/pay")
	public String pay(Integer reginfo_id, Model model) {
		return userReginfoService.pay(reginfo_id, model);
	}

	@RequestMapping("/createTicket")
	public String createTicket(Integer reginfo_id, Model model) {
		return userReginfoService.createTicket(reginfo_id, model);
	}

}
