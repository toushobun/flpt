package com.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminRoomDao;
import com.dao.AdminTestDao;
import com.dao.AdminTestinfoDao;
import com.entity.Room;
import com.entity.Test;
import com.entity.Testinfo;
import com.entity.Testinfo__Room;

@Service("adminTestinfoService")
@Transactional
public class AdminTestinfoServiceImpl implements AdminTestinfoService {
	@Autowired
	private AdminTestinfoDao adminTestinfoDao;
	@Autowired
	private AdminTestDao adminTestDao;
	@Autowired
	private AdminRoomDao adminRoomDao;

	@Override
	public String selectTestinfo(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allTestinfo", adminTestinfoDao.selectTestinfo());
		// 这个指令将转到本地文件层验证
		return "admin/selectTestinfo";
	}
	
	@Override
	public String toAddTestinfo(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("testinfo", new Testinfo());
		
		return "admin/addTestinfo";
	}

	@Override
	public String toAddTestinfoAboutRoom(Testinfo testinfo, Model model) {
		// TODO Auto-generated method stub
		if(adminTestDao.selectATestById(testinfo.getTest_id()).getStatus()!=0) {
			model.addAttribute("msg", "发布失败！该考试已发布！");
			return "admin/addTestinfo";
		}
		model.addAttribute("testinfo", testinfo);
		List<Room> selectedRoom = new ArrayList<Room>();
		for (int i = 0; i < testinfo.getRoom_ids().length; i++) {
			// 设置关联表里的room_id
			selectedRoom.add(adminRoomDao.selectARoomById(testinfo.getRoom_ids()[i]));
		}
		model.addAttribute("selectedRoom", selectedRoom);
		return "admin/addTestinfoAboutRoom";
	}
	
	@Override
	public String addTestinfo(Testinfo testinfo, Model model) {
		// TODO Auto-generated method stub
		if(adminTestinfoDao.addTestinfo(testinfo) > 0) {
			// 将该考试的status更改为1
			Test test = new Test();
			test.setId(testinfo.getTest_id());
			test.setStatus(1);
			adminTestDao.updateTest(test);
			// 要在testinfo表里，通过test_id获取testinfo_id
			Integer testinfo_id = adminTestinfoDao.selectATestinfoByTest_id(testinfo.getTest_id()).getId();
			// 新建一个空对象
			Testinfo__Room testinfo__Room = new Testinfo__Room();
			// 设置关联表里的testinfo_id
			testinfo__Room.setTestinfo_id(testinfo_id);
			// 遍历传过来的room_ids，并将其逐个添加到关联表里
			for (int i = 0; i < testinfo.getRoom_ids().length; i++) {
				// 设置关联表里的room_id
				testinfo__Room.setRoom_id(testinfo.getRoom_ids()[i]);
				testinfo__Room.setRquota(testinfo.getRoom_rquotas()[i]);
				adminTestinfoDao.addTestinfo__room(testinfo__Room);
			}
			
			model.addAttribute("msg", "发布成功！");
		}
		// 这个指令将转到controller层验证
		return "forward:/adminTestinfo/selectTestinfo";
	}

	@Override
	public String deleteTestinfoById(Integer id, Model model) {
		// TODO Auto-generated method stub
//		if(adminTestinfoDao.selectATestinfoById(id).getStatus() != 0) {
//			model.addAttribute("msg", "该考试已有考生报名，若要删除，请先删除对应准考证！");
//			return "forward:/adminTestinfo/selectTestinfo";
//		}
		Integer test_id = adminTestinfoDao.selectATestinfoById(id).getTest_id();
		List<Testinfo__Room> toDeleteList = adminTestinfoDao.selectTestinfo__RoomByTestinfo_id(id);
		for(int i=0;i<toDeleteList.size();i++) {
			adminTestinfoDao.deleteTestinfo__RoomById(toDeleteList.get(i).getId());
		}
		if(adminTestinfoDao.deleteTestinfoById(id) > 0) {
			// 将该考试的status更改为0
			Test test = new Test();
			test.setId(test_id);
			test.setStatus(0);
			adminTestDao.updateTest(test);
			model.addAttribute("msg", "删除成功！");
		}
		return "forward:/adminTestinfo/selectTestinfo";
	}

	@Override
	public String toUpdateTestinfo(Integer id, Model model) {
		// TODO Auto-generated method stub
		Testinfo testinfo = adminTestinfoDao.selectATestinfoById(id); 
		model.addAttribute(testinfo);
		return "admin/updateTestinfo";
	}

	@Override
	public String updateTestinfo(Testinfo testinfo, Model model) {
		// TODO Auto-generated method stub
//		if(adminTestinfoDao.selectATestinfoByTnameAndId(testinfo).size() > 0) {
//			model.addAttribute("msg", "修改失败！该考试名已存在！");
//			// 把原来的Tname传回前端
//			testinfo.setTname(adminTestinfoDao.selectATestinfoById(testinfo.getId()).getTname());
//			model.addAttribute("testinfo", testinfo);
//			return "admin/updateTestinfo";
//		}
		if(adminTestinfoDao.updateTestinfo(testinfo) > 0) {
			model.addAttribute("msg", "修改成功！");
		}
		return "forward:/adminTestinfo/selectTestinfo";
	}

	@Override
	public String selectTestinfoRoomByTestinfo_id(Integer id, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allTestinfoRoom", adminTestinfoDao.selectDetailRoomByTestinfo_id());
		return "admin/selectTestinfoRoom";
	}

}
