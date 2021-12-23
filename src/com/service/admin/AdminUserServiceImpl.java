package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminUserDao;

@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserDao adminUserDao;

	@Override
	public String selectUser(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allUser", adminUserDao.selectUser());
		// 这个指令将转到本地文件层验证
		return "admin/selectUser";
	}

	@Override
	public String deleteUserByUser_id(Integer user_id, Model model) {
		// TODO Auto-generated method stub
		if (adminUserDao.selectReginfoByUser_id(user_id).size() > 0) {
			model.addAttribute("msg", "该考生已报名考试，不允许删除！");
			return "forward:/adminUser/selectUser";
		}
		if (adminUserDao.deleteUserByUser_id(user_id) > 0) {
			model.addAttribute("msg", "删除成功！");
		}
		return "forward:/adminUser/selectUser";
	}

	@Override
	public String searchUser(String keyWord, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allUser", adminUserDao.searchUser(keyWord));
		return "admin/selectUser";
	}
}
