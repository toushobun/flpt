package com.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.ReginfoDao;
import com.dao.TestinfoDao;
import com.entity.Reginfo;
import com.entity.Testinfo;

@Service("userTestinfoService")
@Transactional
public class UserTestinfoServiceImpl implements UserTestinfoService {

	@Autowired
	private TestinfoDao testinfoDao;
	@Autowired
	private ReginfoDao reginfoDao;

	@Override
	public String selectTestinfo(Model model) {
		List<Testinfo> testinfoList = testinfoDao.selectTestinfoByKwargs(null);
		Reginfo reginfoToSelect = new Reginfo();
		for (int i = 0; i < testinfoList.size(); i++) {
			reginfoToSelect.setTestinfo_id((testinfoList.get(i).getTestinfo_id()));
			// 如果该考生已报名此考试，则为0，否则为1
			if (reginfoDao.selectReginfoByKwargs(reginfoToSelect).size() > 0) {
				testinfoList.get(i).setStatus(0);
			} else {
				testinfoList.get(i).setStatus(1);
			}
		}
		model.addAttribute("testinfo", new Testinfo());
		model.addAttribute("testinfoList", testinfoList);
		return "user/testinfo/selectTestinfo";
	}

	@Override
	public String searchTestinfo(Testinfo testinfo, Model model) {
		List<Testinfo> testinfoList = testinfoDao.selectTestinfoFuzzily(testinfo);
		model.addAttribute("testinfo", testinfo);
		model.addAttribute("testinfoList", testinfoList);
		return "user/testinfo/selectTestinfo";
	}

}
