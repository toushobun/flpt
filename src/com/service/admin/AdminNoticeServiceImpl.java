package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.NoticeDao;
import com.entity.Notice;

@Service("adminNoticeService")
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public String selectNotice(Model model) {
		List<Notice> noticeList = noticeDao.selectNoticeByKwargs(null);
		model.addAttribute("notice", new Notice());
		model.addAttribute("noticeList", noticeList);
		return "admin/notice/selectNotice";
	}

	@Override
	public String addNotice(Notice notice, Model model) {
		try {
			noticeDao.addNotice(notice);
			model.addAttribute("msg", "Ìí¼Ó³É¹¦£¡");
			return "forward:/adminNotice/selectNotice";
		} catch (Exception e) {
			model.addAttribute("msg", "Ìí¼ÓÊ§°Ü£¡");
			return "admin/notice/addNotice";
		}
	}

	@Override
	public String deleteNotice(Integer notice_id, Model model) {
		try {
			noticeDao.deleteNoticeByNotice_id(notice_id);
			model.addAttribute("msg", "É¾³ý³É¹¦£¡");
			return "forward:/adminNotice/selectNotice";
		} catch (Exception e) {
			model.addAttribute("msg", "É¾³ýÊ§°Ü£¡");
			return "forward:/adminNotice/selectNotice";
		}
	}

	@Override
	public String selectANotice(Integer notice_id, Model model) {
		Notice noticeToSelect = new Notice();
		noticeToSelect.setNotice_id(notice_id);
		Notice notice = noticeDao.selectNoticeByKwargs(noticeToSelect).get(0);
		model.addAttribute("notice", notice);
		return "admin/notice/noticeDetail";
	}

}
