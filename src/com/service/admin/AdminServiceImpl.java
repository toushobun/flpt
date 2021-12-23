package com.service.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminDao;
import com.entity.Auser;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		List<Auser> auserList = adminDao.selectAuserByKwargs(auser);
		if (auserList.size() > 0) {
			session.setAttribute("auser", auser);
			model.addAttribute("msg", "登录成功！");
			return "admin/index";
		} else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "admin/login";
		}
	}

}
