package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminBuserDao;
import com.entity.Buser;

@Service("adminBuserService")
@Transactional
public class AdminBuserServiceImpl implements AdminBuserService {

	@Autowired
	private AdminBuserDao adminBuserDao;

	@Override
	public String selectBuser(Model model) {
		List<Buser> buserList = adminBuserDao.selectBuserByKwargs(null);
		model.addAttribute("buser", new Buser());
		model.addAttribute("buserList", buserList);
		return "admin/buser/selectBuser";
	}

	@Override
	public String deleteBuser(Integer user_id, Model model) {
		// TODO 删除前确认考生是否已报名考试
		try {
			adminBuserDao.deleteBuserByUser_id(user_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminBuser/selectBuser";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！该考生已报名！请先删除对应报名信息！");
			return "forward:/adminBuser/selectBuser";
		}
	}

	@Override
	public String searchBuser(Buser buser, Model model) {
		List<Buser> buserList = adminBuserDao.selectBuserFuzzily(buser);
		model.addAttribute("buser", buser);
		model.addAttribute("buserList", buserList);
		return "admin/buser/selectBuser";
	}

}
