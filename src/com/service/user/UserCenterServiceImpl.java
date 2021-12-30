package com.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.UserDao;
import com.entity.User;

@Service("userCenterService")
@Transactional
public class UserCenterServiceImpl implements UserCenterService {

	@Autowired
	private UserDao userDao;

	@Override
	public String deleteUser(Integer user_id, Model model) {
		// TODO 销毁用户
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
	public String toUpdateUidphoto(Integer user_id, Model model) {
		// TODO 前往更新照片
		return null;
	}

	@Override
	public String updateUidphoto(User user, Model model) {
		// TODO 更新照片
		return null;
	}

	@Override
	public String toUpdateUpwd(Integer user_id, Model model) {
		// TODO 前往更新密码
		return null;
	}

	@Override
	public String updateUpwd(User user, Model model) {
		// TODO 更新密码
		return null;
	}

}
