package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminReginfoDao;
import com.entity.Reginfo;

@Service("adminReginfoService")
@Transactional
public class AdminReginfoServiceImpl implements AdminReginfoService {

	@Autowired
	private AdminReginfoDao adminReginfoDao;

	@Override
	public String selectReginfo(Model model) {
		List<Reginfo> reginfoList = adminReginfoDao.selectReginfoByKwargs(null);
		model.addAttribute("reginfo", new Reginfo());
		model.addAttribute("reginfoList", reginfoList);
		return "admin/reginfo/selectReginfo";
	}

	@Override
	public String deleteReginfo(Integer reginfo_id, Model model) {
		try {
			adminReginfoDao.deleteReginfoByReginfo_id(reginfo_id);
			model.addAttribute("msg", "É¾³ý³É¹¦£¡");
			return "forward:/adminReginfo/selectReginfo";
		} catch (Exception e) {
			model.addAttribute("msg", "É¾³ýÊ§°Ü£¡");
			return "forward:/adminReginfo/selectReginfo";
		}
	}

	@Override
	public String searchReginfo(Reginfo reginfo, Model model) {
		List<Reginfo> reginfoList = adminReginfoDao.selectReginfoFuzzily(reginfo);
		model.addAttribute("reginfo", reginfo);
		model.addAttribute("reginfoList", reginfoList);
		return "admin/reginfo/selectReginfo";
	}

}
