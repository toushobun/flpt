package com.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.service.user.UserCenterService;

@Controller
@RequestMapping("/userCenter")
public class UserCenterController extends BaseUserController {

	@Autowired
	private UserCenterService userCenterService;

	@RequestMapping("/center")
	public String center() {
		return "user/center/center";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(Integer user_id, Model model, HttpSession session) {
		return userCenterService.deleteUser(user_id, model, session);
	}

	@RequestMapping("/toUpdateIdphoto")
	public String toUpdateIdphoto(User user) {
		return "user/center/updateIdphoto";
	}

	@RequestMapping("/updateIdphoto")
	public String updateIdphoto(User user, HttpServletRequest request, Model model, HttpSession session) {
		return userCenterService.updateIdphoto(user, request, model, session);
	}

	@RequestMapping("/toUpdatePwd")
	public String toUpdatePwd(User user) {
		return "user/center/updatePwd";
	}

	@RequestMapping("/updatePwd")
	public String updatePwd(User user, Model model, HttpSession session) {
		return userCenterService.updatePwd(user, model, session);
	}

}