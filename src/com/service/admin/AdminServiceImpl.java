package com.service.admin;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.AdminDao;
import com.dao.AdminRoomDao;
import com.dao.AdminTestDao;
import com.entity.Auser;
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminTestDao adminTestDao;
	@Autowired
	private AdminRoomDao adminRoomDao;
	
	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		if(adminDao.login(auser) != null && adminDao.login(auser).size() > 0) {
			session.setAttribute("auser", auser);
			session.setAttribute("allTest", adminTestDao.selectTest());
			session.setAttribute("allRoom", adminRoomDao.selectRoom());
			return "admin/index";
		}
		model.addAttribute("msg", "用户名或密码错误！");
		return "admin/login";
	}

}
