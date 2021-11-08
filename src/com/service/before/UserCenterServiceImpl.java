package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.UserCenterDao;
import com.entity.Buser;

@Service("UserCenterService")
@Transactional
public class UserCenterServiceImpl implements UserCenterService {
	
	@Autowired
	UserCenterDao userCenterDao;
	
	@Override
	public String updatePwd(Buser buser, Model model, HttpSession session) {
		// 用户提交修改密码
		String oldPwd = userCenterDao.selectABuserByUser_id((buser.getUser_id())).getUpwd();	// 通过id查找该考生原密码
		if(oldPwd.equals(buser.getUpwd())) {	// 判断该考生原密码是否与输入的考生密码相符
			buser.setUpwd(buser.getNewUpwd());	// 如果相符则将输入的“新密码”覆盖原密码
			userCenterDao.updateBuser(buser);	// 并写入数据库
			model.addAttribute("msg", "密码修改成功！");
			session.setAttribute("buser", userCenterDao.selectABuserByUser_id(buser.getUser_id()));
			return "before/userCenter";
		}
		else {
			model.addAttribute("msg", "密码错误，修改失败！");
			return "before/userUpdatePwd";
		}
	}
	
	@Override
	public String deleteUserByUser_id(Integer id, Model model) {
		// TODO 销毁用户
//		if(adminUserDao.selectTicketByBuser(id).size() > 0) {
//			model.addAttribute("msg", "您已报名考试，无法执行此操作！");
//			return "forward:/userCenter/center";
//		}
//		if(adminUserDao.deleteUserById(id) > 0) {
//			model.addAttribute("msg", "销毁成功！");
//		}
		return "forward:/before/exit";
	}

}
