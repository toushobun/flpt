package com.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.ReginfoDao;
import com.entity.Reginfo;

@Service("userReginfoService")
@Transactional
public class UserReginfoServiceImpl implements UserReginfoService {

	@Autowired
	private ReginfoDao adminReginfoDao;

	@Override
	public String addReginfo(Reginfo reginfo, Model model) {
		try {
//			adminReginfoDao();
			model.addAttribute("msg", "报名成功！");
			return "forward:/userTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "报名失败！");
			return "forward:/userTestinfo/selectTestinfo";
		}
	}

}
