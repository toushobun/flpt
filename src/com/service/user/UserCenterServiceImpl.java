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
	public String updateIdphoto(User user, Model model, HttpSession session) {
		// TODO 更新照片
		User userToSelect = new User();
		userToSelect.setUser_id(user.getUser_id());

		session.setAttribute("user", userDao.selectUserByKwargs(userToSelect).get(0));
		return null;
	}

	@Override
	public String updatePwd(User user, Model model, HttpSession session) {
		try {
			User userToSelect = new User();
			userToSelect.setUser_id(user.getUser_id());
			// 查找原密码
			String oldPwd = userDao.selectUserByKwargs(userToSelect).get(0).getUpwd();
			if (oldPwd.equals(user.getUpwd())) { // 判断该考生原密码是否与输入的考生密码相符
				user.setUpwd(user.getNewUpwd()); // 如果相符则将输入的“新密码”覆盖原密码
				userDao.updateUser(user); // 并写入数据库
				model.addAttribute("msg", "密码修改成功！");
				session.setAttribute("user", userDao.selectUserByKwargs(userToSelect).get(0));
				return "user/center/center";
			} else {
				model.addAttribute("msg", "密码错误！");
				return "user/center/center";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "user/center/updatePwd";
		}
	}

}
