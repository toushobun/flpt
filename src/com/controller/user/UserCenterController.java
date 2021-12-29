package com.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userCenter")
public class UserCenterController extends BaseUserController {

	@RequestMapping("/center")
	public String center() {
		return "user/center/center";
	}

}
