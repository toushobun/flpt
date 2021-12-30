package com.service.user;

import javax.servlet.http.HttpSession;

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
	public String deleteUser(Integer user_id, Model model, HttpSession session) {
		try {
			userDao.deleteUserByUser_id(user_id);
			model.addAttribute("msg", "销毁成功！");
			session.invalidate();
			return "user/index";
		} catch (Exception e) {
			model.addAttribute("msg", "销毁失败！您还有报名信息存留，请先删除您的历史报名信息！");
			return "forward:/userReginfo/selectReginfo?user_id=" + user_id;
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
