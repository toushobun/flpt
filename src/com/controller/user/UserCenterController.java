package com.controller.user;

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
	public String deleteUser(Integer user_id, Model model) {
		return userCenterService.deleteUser(user_id, model);
	}

	@RequestMapping("/toUpdateUidphoto")
	public String toUpdateUidphoto(Integer user_id, Model model) {
		return userCenterService.toUpdateUidphoto(user_id, model);
	}

	@RequestMapping("/updateUidphoto")
	public String updateUidphoto(User user, Model model) {
		return userCenterService.updateUidphoto(user, model);
	}

	@RequestMapping("/toUpdateUpwd")
	public String toUpdateUpwd(Integer user_id, Model model) {
		return userCenterService.toUpdateUpwd(user_id, model);
	}

	@RequestMapping("/updateUpwd")
	public String updateUpwd(User user, Model model) {
		return userCenterService.updateUpwd(user, model);
	}

}