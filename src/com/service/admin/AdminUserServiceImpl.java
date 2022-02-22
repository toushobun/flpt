package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.UserDao;
import com.entity.User;

@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String selectUser(Model model) {
		List<User> userList = userDao.selectUserByKwargs(null);
		model.addAttribute("user", new User());
		model.addAttribute("userList", userList);
		return "admin/user/selectUser";
	}

	@Override
	public String deleteUser(Integer user_id, Model model) {
		try {
			userDao.deleteUserByUser_id(user_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminUser/selectUser";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！该考生已报名！请先删除对应报名信息！");
			return "forward:/adminUser/selectUser";
		}
	}

	@Override
	public String searchUser(User user, Model model) {
		List<User> userList = userDao.selectUserFuzzily(user);
		model.addAttribute("user", user);
		model.addAttribute("userList", userList);
		return "admin/user/selectUser";
	}

}
