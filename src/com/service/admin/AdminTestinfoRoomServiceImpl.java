package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminTestinfoRoomDao;
import com.entity.Testinfo__room;

@Service("adminTestinfoRoomService")
@Transactional
public class AdminTestinfoRoomServiceImpl implements AdminTestinfoRoomService {

	@Autowired
	private AdminTestinfoRoomDao adminTestinfoRoomDao;

	@Override
	public String selectTestinfoRoom(Testinfo__room testinfo__room, Model model) {
		// TODO 要插入个notSelectedRoom列表显示可以额外选择的考场
		List<Testinfo__room> testinfoRoomList = adminTestinfoRoomDao.selectTestinfoRoomByKwargs(testinfo__room);
		model.addAttribute("testinfoRoom", new Testinfo__room());
		model.addAttribute("testinfoRoomList", testinfoRoomList);
		return "admin/testinfoRoom/selectTestinfoRoom";
	}

}
