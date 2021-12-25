package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminTestDao;
import com.dao.AdminTestinfoDao;
import com.entity.Test;
import com.entity.Testinfo;

@Service("adminTestinfoService")
@Transactional
public class AdminTestinfoServiceImpl implements AdminTestinfoService {

	@Autowired
	private AdminTestinfoDao adminTestinfoDao;

	@Autowired
	private AdminTestDao adminTestDao;

	@Override
	public String selectTestinfo(Model model) {
		List<Testinfo> testinfoList = adminTestinfoDao.selectTestinfoByKwargs(null);
		model.addAttribute("testinfo", new Testinfo());
		model.addAttribute("testinfoList", testinfoList);
		return "admin/testinfo/selectTestinfo";
	}

	@Override
	public String addTestinfo(Testinfo testinfo, Model model) {
		try {
			adminTestinfoDao.addTestinfo(testinfo);
			model.addAttribute("msg", "添加成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "添加失败！");
			return "admin/testinfo/addTestinfo";
		}
	}

	@Override
	public String deleteTestinfo(Integer testinfo_id, Model model) {
		try {
			adminTestinfoDao.deleteTestinfoByTestinfo_id(testinfo_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！该考试已发布考场，请先删除对应考场！");
			return "forward:/adminTestinfo/selectTestinfo";
		}
	}

	@Override
	public String toUpdateTestinfo(Integer testinfo_id, Model model) {
		List<Test> testList = adminTestDao.selectTestByKwargs(null);
		model.addAttribute("testList", testList);
		Testinfo testinfoToSelect = new Testinfo();
		testinfoToSelect.setTestinfo_id(testinfo_id);
		Testinfo testinfo = adminTestinfoDao.selectTestinfoByKwargs(testinfoToSelect).get(0);
		model.addAttribute("testinfo", testinfo);
		return "admin/testinfo/updateTestinfo";
	}

	@Override
	public String updateTestinfo(Testinfo testinfo, Model model) {
		try {
			adminTestinfoDao.updateTestinfo(testinfo);
			model.addAttribute("msg", "修改成功！");
			return "forward:/adminTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "admin/testinfo/updateTestinfo";
		}
	}

	@Override
	public String searchTestinfo(Testinfo testinfo, Model model) {
		List<Testinfo> testinfoList = adminTestinfoDao.selectTestinfoFuzzily(testinfo);
		model.addAttribute("testinfo", testinfo);
		model.addAttribute("testinfoList", testinfoList);
		return "admin/testinfo/selectTestinfo";
	}

}
