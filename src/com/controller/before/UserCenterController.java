package com.controller.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Buser;
import com.service.before.UserCenterService;

@Controller
@RequestMapping("/userCenter")
public class UserCenterController extends BaseBeforeController {

	@Autowired
	private UserCenterService userCenterService;

	@RequestMapping("/center")
	public String center() {
		return "before/userCenter";
	}

	@RequestMapping("/toUpdatePwd")
	public String toUpdatePwd(@ModelAttribute Buser buser) {
		return "before/userUpdatePwd";
	}

	@RequestMapping("/updatePwd")
	public String updatePwd(@ModelAttribute Buser buser, Model model, HttpSession session) {
		return userCenterService.updatePwd(buser, model, session);
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id, Model model) {
		return userCenterService.deleteUserByUser_id(id, model);
	}

}
