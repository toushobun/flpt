package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.ReginfoDao;
import com.entity.Reginfo;

@Service("adminReginfoService")
@Transactional
public class AdminReginfoServiceImpl implements AdminReginfoService {

	@Autowired
	private ReginfoDao reginfoDao;

	@Override
	public String selectReginfo(Model model) {
		// TODO 对报名信息状态进行处理
		List<Reginfo> reginfoList = reginfoDao.selectReginfoByKwargs(null);
		model.addAttribute("reginfo", new Reginfo());
		model.addAttribute("reginfoList", reginfoList);
		return "admin/reginfo/selectReginfo";
	}

	@Override
	public String deleteReginfo(Integer reginfo_id, Model model) {
		// TODO 如果删除的是考生取消以外状态的报名信息，则需要增加对应考场的名额
		try {
			reginfoDao.deleteReginfoByReginfo_id(reginfo_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminReginfo/selectReginfo";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！");
			return "forward:/adminReginfo/selectReginfo";
		}
	}

	@Override
	public String searchReginfo(Reginfo reginfo, Model model) {
		List<Reginfo> reginfoList = reginfoDao.selectReginfoFuzzily(reginfo);
		model.addAttribute("reginfo", reginfo);
		model.addAttribute("reginfoList", reginfoList);
		return "admin/reginfo/selectReginfo";
	}

}
