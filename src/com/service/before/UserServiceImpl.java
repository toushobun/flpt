package com.service.before;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminNoticeDao;
import com.dao.UserDao;
import com.entity.Buser;
import com.entity.Notice;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private AdminNoticeDao adminNoticeDao;

	@Override
	public String login(Buser buser, Model model, HttpSession session, String code) {
		// TODO Auto-generated method stub
		if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg", "验证码错误！");
			return "before/login";
		}
		Buser userDetail = null;
		List<Buser> list = userDao.login(buser);
		if (list.size() > 0) {
			userDetail = list.get(0);
		}
		if (userDetail != null) {
			model.addAttribute("allNotices", adminNoticeDao.selectNotice());
			session.setAttribute("buser", userDetail);
			return "before/index";
		} else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "before/login";
		}
	}

	@Override
	public String register(Buser buser, Model model, HttpSession session, String code) {
		// TODO Auto-generated method stub
		if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg", "验证码错误！");
			return "before/register";
		}
		buser.setUser_id(-1);
		if (userDao.selectBuserByUidnum(buser.getUidnum()).size() > 0) {
			model.addAttribute("msg", "注册失败！（该身份证号已被注册）");
			return "before/register";
		}
		buser.setUser_id(null);
		if (userDao.register(buser) > 0) {
			model.addAttribute("allNotices", adminNoticeDao.selectNotice());
			model.addAttribute("msg", "注册成功！");
		}
		return "before/login";
	}

	@Override
	public String userSelectANoticeByNotice_id(Model model, Integer notice_id) {
		Notice notice = adminNoticeDao.selectANoticeByNotice_id(notice_id);
		model.addAttribute("notice", notice);
		return "before/noticeDetail";
	}

	@Override
	public String userSelectNotice(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allNotices", adminNoticeDao.selectNotice());
		return "before/userSelectNotice";
	}

}
