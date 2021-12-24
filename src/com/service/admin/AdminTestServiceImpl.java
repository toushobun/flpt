package com.service.admin;

import java.util.List;

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
		List<Test> testList = adminTestDao.selectTestByKwargs(null);
		model.addAttribute("testList", testList);
		return "admin/selectTest";
	}

	@Override
	public String addTest(Test test, Model model) {
		try {
			Test testToSelect = new Test();
			testToSelect.setTname(test.getTname());
			List<Test> testList = adminTestDao.selectRepeatedTest(testToSelect);
			if (testList.size() > 0) {
				model.addAttribute("msg", "添加失败！该考试已存在！");
				return "admin/addTest";
			}
			adminTestDao.addTest(test);
			model.addAttribute("msg", "添加成功！");
			return "forward:/adminTest/selectTest";
		} catch (Exception e) {
			model.addAttribute("msg", "添加失败！");
			return "admin/addTest";
		}
	}

	@Override
	public String deleteTest(Integer test_id, Model model) {
		try {
			Test testToSelect = new Test();
			testToSelect.setTest_id(test_id);
			Test test = adminTestDao.selectTestByKwargs(testToSelect).get(0);
			if (test.getStatus() != 0) {
				model.addAttribute("msg", "删除失败！该考试已发布！");
				return "forward:/adminTest/selectTest";
			}
			adminTestDao.deleteTestByTest_id(test_id);
			model.addAttribute("msg", "删除成功！");
			return "forward:/adminTest/selectTest";
		} catch (Exception e) {
			model.addAttribute("msg", "删除失败！");
			return "forward:/adminTest/selectTest";
		}
	}

	@Override
	public String toUpdateTest(Integer test_id, Model model) {
		Test testToSelect = new Test();
		testToSelect.setTest_id(test_id);
		Test test = adminTestDao.selectTestByKwargs(testToSelect).get(0);
		model.addAttribute("test", test);
		return "admin/updateTest";
	}

	@Override
	public String updateTest(Test test, Model model) {
		// TODO Auto-generated method stub
		try {
			Test testToSelect = new Test();
			testToSelect.setTest_id(test.getTest_id());
			testToSelect.setTname(test.getTname());
			List<Test> testList = adminTestDao.selectRepeatedTest(testToSelect);
			if (testList.size() > 0) {
				model.addAttribute("msg", "修改失败！该考试已存在！");
				return "admin/updateTest";
			}
			adminTestDao.updateTest(test);
			model.addAttribute("msg", "修改成功！");
			return "forward:/adminTest/selectTest";
		} catch (Exception e) {
			model.addAttribute("msg", "修改失败！");
			return "admin/updateTest";
		}
	}

	@Override
	public String searchTest(String keyWord, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
