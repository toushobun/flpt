package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminNoticeDao;
import com.entity.Notice;

@Service("adminNoticeService")
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService{
	@Autowired
	private AdminNoticeDao adminNoticeDao;
	@Override
	public String addNotice(Model model, Notice notice) {
		// TODO Auto-generated method stub
		adminNoticeDao.addNotice(notice);
		model.addAttribute("msg", "添加成功！");
		return "forward:/adminNotice/selectNotice";
	}
	@Override
	public String selectANoticeById(Model model, Integer id) {
		// TODO Auto-generated method stub
		model.addAttribute("notice", adminNoticeDao.selectANoticeById(id));
		return "admin/noticeDetail";
	}
	@Override
	public String deleteNoticeById(Model model, Integer id) {
		// TODO Auto-generated method stub
		adminNoticeDao.deleteNoticeById(id);
		model.addAttribute("msg", "删除成功！");
		return "forward:/adminNotice/selectNotice";
	}
	@Override
	public String selectNotice(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allNotices", adminNoticeDao.selectNotice());
		return "admin/selectNotice";
	}

}
