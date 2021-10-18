package com.service.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String selectTestinfo(HttpSession session) {
		// TODO 转到selectTestinfo页，展示所有已发布考试
		session.setAttribute("allTestinfo", adminTestinfoDao.selectTestinfo());
		// 这个指令将转到本地文件层验证
		return "admin/selectTestinfo";
	}
	
	@Override
	public String toAddTestinfo(Model model) {
		// TODO 前往addTestinfo，将空考试发送给发布考试页
		model.addAttribute("testinfo", new Testinfo());
		
		return "admin/addTestinfo";
	}

	@Override
	public String toAddTestinfoRoom(Testinfo testinfo, Model model) {
		// TODO 前往addTestinfoRoom，为选中的考场配置考试名额
		if(adminTestDao.selectATestByTest_id(testinfo.getTest_id()).getStatus()!=0) {
			model.addAttribute("msg", "发布失败！该考试已发布！");
			return "admin/addTestinfo";
		}
		model.addAttribute("testinfo", testinfo);
		List<Room> selectedRoom = new ArrayList<Room>();
		for (int i = 0; i < testinfo.getRoom_ids().length; i++) {
			// 设置关联表里的room_id
			selectedRoom.add(adminRoomDao.selectARoomByRoom_id(testinfo.getRoom_ids()[i]));
		}
		model.addAttribute("selectedRoom", selectedRoom);
		return "admin/addTestinfoRoom";
	}

	@Override
	public String toAddTestinfoNewRoom(Testinfo testinfo, Model model) {
		// TODO 前往为已经发布的考试添加额外考场
		// 查询考试发布出来的信息
		Testinfo testinfoDetail = adminTestinfoDao.selectATestinfoByTestinfo_id(testinfo.getTestinfo_id());
		// 查询考试详细信息
		Test testDetail = adminTestDao.selectATestByTest_id(testinfoDetail.getTest_id());
		testinfoDetail.setTname(testDetail.getTname());
		testinfoDetail.setTname(testDetail.getTsubject());
		testinfoDetail.setTname(testDetail.getTorganizer());
		// 将完整的考试信息发出去
		model.addAttribute("testinfo", testinfoDetail);
		List<Room> selectedRoom = new ArrayList<Room>();
		for (int i = 0; i < testinfo.getRoom_ids().length; i++) {
			// 设置关联表里的room_id
			selectedRoom.add(adminRoomDao.selectARoomByRoom_id(testinfo.getRoom_ids()[i]));
		}
		model.addAttribute("selectedRoom", selectedRoom);
		return "admin/addTestinfoNewRoom";
	}
	
	@Override
	public String addTestinfo(Testinfo testinfo, Model model, HttpSession session) {
		// TODO 发布新考试，并将新发布的考试更新到session
		if(adminTestinfoDao.addTestinfo(testinfo) > 0) {
			// 将该考试的status更改为1
			Test test = new Test();
			test.setTest_id(testinfo.getTest_id());
			test.setStatus(1);
			adminTestDao.updateTest(test);
			// 要在testinfo表里，通过test_id获取testinfo_id
			Integer testinfo_id = adminTestinfoDao.selectATestinfoByTest_id(testinfo.getTest_id()).getTestinfo_id();
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
			session.setAttribute("allTest", adminTestDao.selectTest());
			session.setAttribute("allTestinfo", adminTestinfoDao.selectTestinfo());
			model.addAttribute("msg", "发布成功！");
		}
		// 这个指令将转到controller层验证
		return "forward:/adminTestinfo/selectTestinfo";
	}

	@Override
	public String addTestinfoRoom(Testinfo testinfo, Model model, HttpSession session) {
		// TODO 为已经发布的考试添加新考场，并将新考场更新到session
		// 要在testinfo表里，通过test_id获取testinfo_id
		Integer testinfo_id = adminTestinfoDao.selectATestinfoByTest_id(testinfo.getTest_id()).getTestinfo_id();
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
		model.addAttribute("msg", "添加成功！");
		session.setAttribute("notSelectedRoom", adminRoomDao.selectRoomByTestinfo_id(testinfo_id));
		session.setAttribute("allTestinfo__Room", adminTestinfoDao.selectTestinfo__RoomByTestinfo_id(testinfo__Room.getTestinfo_id()));
		return "admin/selectTestinfoRoom";
	}

	@Override
	public String deleteTestinfoByTestinfo_id(Integer testinfo_id, Model model, HttpSession session) {
		// TODO 通过id删除考试信息，删除前确认是否有学生报名，删除后更新到session
		if(adminTestinfoDao.selectAReginfoByTestinfo_id(testinfo_id).size() > 0) {
			model.addAttribute("msg", "该考试已有考生报名，若要删除，请先删除对应准考证！");
			return "forward:/adminTestinfo/selectTestinfo";
		}
		Integer test_id = adminTestinfoDao.selectATestinfoByTestinfo_id(testinfo_id).getTest_id();
		List<Testinfo__Room> toDeleteList = adminTestinfoDao.selectTestinfo__RoomByTestinfo_id(testinfo_id);
		for(int i=0;i<toDeleteList.size();i++) {
			adminTestinfoDao.deleteTestinfo__RoomByTestinfo__room_id(toDeleteList.get(i).getTestinfo__room_id());
		}
		if(adminTestinfoDao.deleteTestinfoByTestinfo_id(testinfo_id) > 0) {
			// 将该考试的status更改为0
			Test test = new Test();
			test.setTest_id(test_id);
			test.setStatus(0);
			adminTestDao.updateTest(test);
			session.setAttribute("allTestinfo", adminTestinfoDao.selectTestinfo());
			model.addAttribute("msg", "删除成功！");
		}
		return "forward:/adminTestinfo/selectTestinfo";
	}

	@Override
	public String toUpdateTestinfo(Integer testinfo_id, Model model) {
		// TODO 前往更新考试信息页
		Testinfo testinfo = adminTestinfoDao.selectATestinfoByTestinfo_id(testinfo_id); 
		model.addAttribute(testinfo);
		return "admin/updateTestinfo";
	}

	@Override
	public String updateTestinfo(Testinfo testinfo, Model model, HttpSession session) {
		// TODO 更新考试信息，更新后更新数据到session
		if(adminTestinfoDao.updateTestinfo(testinfo) > 0) {
			session.setAttribute("allTestinfo", adminTestinfoDao.selectTestinfo());
			model.addAttribute("msg", "修改成功！");
		}
		return "forward:/adminTestinfo/selectTestinfo";
	}

	@Override
	public String selectTestinfoRoom(Integer testinfo_id, Model model, HttpSession session) {
		// TODO 查询某个已发布考试的具体考场
		session.setAttribute("allTestinfo__Room", adminTestinfoDao.selectTestinfo__RoomByTestinfo_id(testinfo_id));
		session.setAttribute("notSelectedRoom", adminRoomDao.selectRoomByTestinfo_id(testinfo_id));
		model.addAttribute("testinfo", adminTestinfoDao.selectATestinfoByTestinfo_id(testinfo_id));
		return "admin/selectTestinfoRoom";
	}
	
	@Override
	public String updateRoomQuota(Testinfo__Room testinfo__Room, Model model, HttpSession session) {
		// TODO 更新某个已发布考试的考场名额，并将数据更新到session
		if(adminTestinfoDao.updateRoomQuota(testinfo__Room) > 0) {
			model.addAttribute("msg", "修改成功！");
		}
		session.setAttribute("notSelectedRoom", adminRoomDao.selectRoomByTestinfo_id(testinfo__Room.getTestinfo_id()));
		session.setAttribute("allTestinfo__Room", adminTestinfoDao.selectTestinfo__RoomByTestinfo_id(testinfo__Room.getTestinfo_id()));
		model.addAttribute("testinfo", adminTestinfoDao.selectATestinfoByTestinfo_id(testinfo__Room.getTestinfo_id()));
		return "admin/selectTestinfoRoom";
	}

	@Override
	public String cancelRoom(Testinfo__Room testinfo__Room, Model model, HttpSession session) {
		// TODO 取消某个已发布考试的考场，并将数据更新到session
		if(adminTestinfoDao.selectTestinfo__RoomByTestinfo_id(testinfo__Room.getTestinfo_id()).size() == 1) {
			model.addAttribute("msg", "至少要留一个考场！");
		}
		else if(adminTestinfoDao.selectAReginfoByRoom_id(testinfo__Room.getRoom_id()).size() > 0) {
			model.addAttribute("msg", "该考场已有学生报名！请先取消对应学生的考试资格（删除准考证）！");
		}
		else if(adminTestinfoDao.deleteTestinfo__RoomByTestinfo__room_id(testinfo__Room.getTestinfo__room_id()) > 0) {
			model.addAttribute("msg", "取消成功！");
		}
		session.setAttribute("notSelectedRoom", adminRoomDao.selectRoomByTestinfo_id(testinfo__Room.getTestinfo_id()));
        session.setAttribute("allTestinfo__Room", adminTestinfoDao.selectTestinfo__RoomByTestinfo_id(testinfo__Room.getTestinfo_id()));
		model.addAttribute("testinfo", adminTestinfoDao.selectATestinfoByTestinfo_id(testinfo__Room.getTestinfo_id()));
		return "admin/selectTestinfoRoom";
	}

	@Override
	public String searchTestinfo(String keyWord, HttpSession session) {
		// TODO 模糊查询考试信息
		session.setAttribute("allTestinfo", adminTestinfoDao.searchTestinfo(keyWord));
		return "admin/selectTestinfo";
	}

}
