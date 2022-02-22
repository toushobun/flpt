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
	public String selectTestinfo(Integer user_id, Model model) {
		List<Testinfo> testinfoList = testinfoDao.selectTestinfoByKwargs(null);
		Reginfo reginfoToSelect = new Reginfo();
		for (int i = 0; i < testinfoList.size(); i++) {
			// 已报名未支付为0，已报名已支付为1，被取消或未报名等情况为2
			testinfoList.get(i).setStatus(2);
			reginfoToSelect.setUser_id(user_id);
			reginfoToSelect.setTestinfo_id((testinfoList.get(i).getTestinfo_id()));
			List<Reginfo> reginfoList = reginfoDao.selectReginfoByKwargs(reginfoToSelect);
			Integer status;
			for (int j = 0; j < reginfoList.size(); j++) {
				status = reginfoList.get(j).getStatus();
				if (status == 0 || status == 1) {
					testinfoList.get(i).setStatus(status);
					break;
				}
			}
		}
		model.addAttribute("testinfo", new Testinfo());
		model.addAttribute("testinfoList", testinfoList);
		return "user/testinfo/selectTestinfo";
	}

	@Override
	public String searchTestinfo(Testinfo testinfo, Model model) {
		List<Testinfo> testinfoList = testinfoDao.selectTestinfoFuzzily(testinfo);
		Reginfo reginfoToSelect = new Reginfo();
		for (int i = 0; i < testinfoList.size(); i++) {
			// 已报名未支付为0，已报名已支付为1，被取消或未报名等情况为2
			testinfoList.get(i).setStatus(1);
			reginfoToSelect.setUser_id(testinfo.getUser_id());
			reginfoToSelect.setTestinfo_id((testinfoList.get(i).getTestinfo_id()));
			List<Reginfo> reginfoList = reginfoDao.selectReginfoByKwargs(reginfoToSelect);
			Integer status;
			for (int j = 0; j < reginfoList.size(); j++) {
				status = reginfoList.get(j).getStatus();
				if (status == 0 || status == 1) {
					testinfoList.get(i).setStatus(status);
					break;
				}
			}
		}
		model.addAttribute("testinfo", testinfo);
		model.addAttribute("testinfoList", testinfoList);
		return "user/testinfo/selectTestinfo";
	}

}
