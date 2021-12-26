package com.service.user;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.UserDao;
import com.entity.Buser;
import com.util.MyUtil;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String login(Buser buser, Model model, HttpSession session) {
		List<Buser> buserList = userDao.selectBuserByKwargs(buser);
		if (buserList.size() > 0) {
			session.setAttribute("buser", buserList.get(0));
			model.addAttribute("msg", "登录成功！");
			return "user/index";
		} else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "user/login";
		}
	}

	@Override
	public String register(Buser buser, HttpServletRequest request, Model model, HttpSession session, String code) {
		try {
			if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
				model.addAttribute("msg", "验证码错误！");
				return "user/register";
			}
			Buser buserToSelect = new Buser();
			buserToSelect.setUidnum(buser.getUidnum());
			if (userDao.selectBuserByKwargs(buserToSelect).size() > 0) {
				model.addAttribute("msg", "注册失败！（该身份证号已被注册）");
				return "user/register";
			}
			/*
			 * 上传文件的保存位置"/logos"，该位置是指
			 * workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps，
			 * 发布后使用
			 */
			// 防止文件名重名
			String newFileName = "";
			String fileName = buser.getLogoImage().getOriginalFilename();
			// 选择了文件
			if (fileName.length() > 0) {
				String realpath = request.getServletContext().getRealPath("logos");
				// 实现文件上传
				String fileType = fileName.substring(fileName.lastIndexOf('.'));
				// 防止文件名重名
				newFileName = MyUtil.getStringID() + fileType;
				buser.setUidphoto(newFileName);
				File targetFile = new File(realpath, newFileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// 上传
				try {
					buser.getLogoImage().transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			userDao.register(buser);
			model.addAttribute("noticeList", userDao.selectNoticeByKwargs(null));
			model.addAttribute("msg", "注册成功！");
			return "user/login";
		} catch (Exception e) {
			model.addAttribute("msg", "注册失败！");
			return "user/register";
		}
	}

	@Override
	public String userSelectNotice(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userSelectANotice(Integer notice_id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
