package com.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.NoticeDao;
import com.entity.Notice;

@Service("userNoticeService")
@Transactional
public class UserNoticeServiceImpl implements UserNoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public String selectNotice(Model model) {
		List<Notice> noticeList = noticeDao.selectNoticeByKwargs(null);
		model.addAttribute("noticeList", noticeList);
		return "user/notice/selectNotice";
	}

	@Override
	public String selectANotice(Notice notice, Model model) {
		notice = noticeDao.selectNoticeByKwargs(notice).get(0);
		model.addAttribute("notice", notice);
		return "user/notice/noticeDetail";
	}

}
