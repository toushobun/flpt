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
	public String selectANoticeByNotice_id(Model model, Integer notice_id) {
		// TODO Auto-generated method stub
		model.addAttribute("notice", adminNoticeDao.selectANoticeByNotice_id(notice_id));
		return "admin/noticeDetail";
	}
	@Override
	public String deleteNoticeByNotice_id(Model model, Integer notice_id) {
		// TODO Auto-generated method stub
		adminNoticeDao.deleteNoticeByNotice_id(notice_id);
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
