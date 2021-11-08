package com.controller.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Reginfo;
import com.service.before.UserReginfoService;

@Controller
@RequestMapping("/userReginfo")
public class UserReginfoController extends BaseBeforeController {
	@Autowired
	private UserReginfoService userReginfoService;
	@RequestMapping("/userSelectTestinfo")
	public String userSelectTestinfo(Model model) {
		return userReginfoService.userSelectTestinfo(model);
	}
	@RequestMapping("/userSelectTestinfoRoom")
	public String userSelectTestinfoRoom(Integer testinfo_id, Model model) {
		return userReginfoService.userSelectTestinfoRoom(testinfo_id, model);
	}
	@RequestMapping("/userAddReginfo")
	public String userAddReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.userAddReginfo(reginfo, model);
	}
	@RequestMapping("/userSelectAReginfo")
	public String userSelectAReginfo(Reginfo reginfo, Model model) {
		return userReginfoService.userSelectAReginfoByUser_idAndTestinfo_id(reginfo, model);
	}
	@RequestMapping("/userToPay")
	public String userToPay(Reginfo reginfo, Model model) {
		return userReginfoService.userToPay(reginfo, model);
	}
	@RequestMapping("/userPayDone")
	public String userPayDone(Integer reginfo_id, Model model) {
		return userReginfoService.userPay(reginfo_id, model);
	}
	@RequestMapping("userCancelReginfo")
	public String userCancelReginfo(Integer reginfo_id, Model model) {
		return userReginfoService.userCancelReginfo(reginfo_id, model);
	}
	@RequestMapping("userToChangeRoom")
	public String userToChangeRoom(Reginfo reginfo, Model model) {
		return userReginfoService.userToChangeRoom(reginfo, model);
	}
	@RequestMapping("userChangeRoom")
	public String userChangeRoom(Reginfo reginfo, Model model) {
		return userReginfoService.userChangeRoom(reginfo, model);
	}
	@RequestMapping("userGetTicket")
	public String userGetTicket(Reginfo reginfo, Model model) {
		return userReginfoService.userGetTicket(reginfo, model);
	}
	@RequestMapping("userSelectReginfo")
	public String userSelectReginfo(Integer user_id, Model model) {
		return userReginfoService.userSelectReginfoByUser_id(user_id, model);
	}
	
}
