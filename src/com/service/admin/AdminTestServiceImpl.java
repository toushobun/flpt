package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminTestDao;
import com.entity.Test;

@Service("adminTestService")
@Transactional
public class AdminTestServiceImpl implements AdminTestService {

	@Autowired
	private AdminTestDao adminTestDao;

	@Override
	public String selectTest(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allTest", adminTestDao.selectTest());
		// 这个指令将转到本地文件层验证
		return "admin/selectTest";
	}

	@Override
	public String addTest(Test test, Model model) {
		// TODO Auto-generated method stub
		if (adminTestDao.selectATestByTname(test.getTname()).size() > 0) {
			model.addAttribute("msg", "添加失败！该考试名已存在！");
			return "admin/addTest";
		}
		if (adminTestDao.addTest(test) > 0) {
			model.addAttribute("msg", "添加成功！");
		}
		// 这个指令将转到controller层验证
		return "forward:/adminTest/selectTest";
	}

	@Override
	public String deleteTestByTest_id(Integer test_id, Model model) {
		// TODO Auto-generated method stub
		if (adminTestDao.selectATestByTest_id(test_id).getStatus() != 0) {
			model.addAttribute("msg", "该考试已发布，不允许删除！");
			return "forward:/adminTest/selectTest";
		}
		if (adminTestDao.deleteTestByTest_id(test_id) > 0) {
			model.addAttribute("msg", "删除成功！");
		}
		return "forward:/adminTest/selectTest";
	}

	@Override
	public String toUpdateTest(Integer test_id, Model model) {
		// TODO Auto-generated method stub
		Test test = adminTestDao.selectATestByTest_id(test_id);
		model.addAttribute("test", test);
		return "admin/updateTest";
	}

	@Override
	public String updateTest(Test test, Model model) {
		// TODO Auto-generated method stub
		if (adminTestDao.selectATestByTnameAndTest_id(test).size() > 0) {
			model.addAttribute("msg", "修改失败！该考试名已存在！");
			// 把原来的Tname传回前端
			test.setTname(adminTestDao.selectATestByTest_id(test.getTest_id()).getTname());
			model.addAttribute("test", test);
			return "admin/updateTest";
		}
		if (adminTestDao.updateTest(test) > 0) {
			model.addAttribute("msg", "修改成功！");
		}
		return "forward:/adminTest/selectTest";
	}

	@Override
	public String searchTest(String keyWord, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allTest", adminTestDao.searchTest(keyWord));
		return "admin/selectTest";
	}

}
