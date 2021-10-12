//package com.exam.controller.before;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.exam.entity.Buser;
//import com.exam.service.before.UserCenterService;
//
//@Controller
//@RequestMapping("/userCenter")
//public class UserCenterController extends BaseBeforeController {
//	
//	@Autowired
//	private UserCenterService userCenterService;
//	@RequestMapping("/toChooseExaminfo")
//	public String toChooseExaminfo(Integer id, int status, Model model) {
//		return userCenterService.toChooseExaminfo(id, status, model);
//	}
//	@RequestMapping("/center")
//	public String center() {
//		return "before/center";
//	}
//	@RequestMapping("/toUpdateBuser")
//	public String toUpdateBuser(@ModelAttribute Buser buser) {
//		return "before/updateBuser";
//	}
//	@RequestMapping("/updateBuser")
//	public String updateBuser(@ModelAttribute Buser buser, Model model, HttpSession session) {
//		return userCenterService.updateBuser(buser, model, session);
//	}
//	@RequestMapping("/toUpdatePwd")
//	public String toUpdatePwd(@ModelAttribute Buser buser) {
//		return "before/updatePwd";
//	}
//	@RequestMapping("/updatePwd")
//	public String updatePwd(@ModelAttribute Buser buser, Model model, HttpSession session) {
//		return userCenterService.updatePwd(buser, model, session);
//	}
//	@RequestMapping("/deleteUser")
//	public String deleteUser(Integer id, Model model) {
//		return userCenterService.deleteUserById(id, model);
//	}
//}
