package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminRoomDao;
import com.entity.Room;

@Service("adminRoomService")
@Transactional
public class AdminRoomServiceImpl implements AdminRoomService {
	
	@Autowired
	private AdminRoomDao adminRoomDao;

	@Override
	public String selectRoom(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allRoom", adminRoomDao.selectRoom());
		// 这个指令将转到本地文件层验证
		return "admin/selectRoom";
	}
	
	@Override
	public String addRoom(Room room, Model model) {
		// TODO Auto-generated method stub
		if(adminRoomDao.selectARoomByRname(room.getRname()).size() > 0) {
			model.addAttribute("msg", "添加失败！该考场名已存在！");
			return "admin/addRoom";
		}
		if(adminRoomDao.addRoom(room) > 0) {
			model.addAttribute("allRoom", adminRoomDao.selectRoom());
			model.addAttribute("msg", "添加成功！");
		}
		// 这个指令将转到controller层验证
		return "forward:/adminRoom/selectRoom";
	}

	@Override
	public String deleteRoomByRoom_id(Integer room_id, Model model) {
		// TODO Auto-generated method stub
		if(adminRoomDao.selectATestinfo__roomByRoom_id(room_id).size() > 0) {
			model.addAttribute("msg", "该考点已作为考场发布，不允许删除！");
			return "forward:/adminRoom/selectRoom";
		}
		if(adminRoomDao.deleteRoomByRoom_id(room_id) > 0) {
			model.addAttribute("allRoom", adminRoomDao.selectRoom());
			model.addAttribute("msg", "删除成功！");
		}
		return "forward:/adminRoom/selectRoom";
	}

	@Override
	public String toUpdateRoom(Integer room_id, Model model) {
		// TODO Auto-generated method stub
		Room room = adminRoomDao.selectARoomByRoom_id(room_id); 
		model.addAttribute("room", room);
		return "admin/updateRoom";
	}

	@Override
	public String updateRoom(Room room, Model model) {
		// TODO Auto-generated method stub
		if(adminRoomDao.selectARoomByRnameAndRoom_id(room).size() > 0) {
			model.addAttribute("msg", "修改失败！该考场名已存在！");
			// 把原来的Rname传回前端
			room.setRname(adminRoomDao.selectARoomByRoom_id(room.getRoom_id()).getRname());
			model.addAttribute("room", room);
			return "admin/updateRoom";
		}
		if(adminRoomDao.updateRoom(room) > 0) {
			model.addAttribute("allRoom", adminRoomDao.selectRoom());
			model.addAttribute("msg", "修改成功！");
		}
		return "forward:/adminRoom/selectRoom";
	}

	@Override
	public String searchRoom(String keyWord, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allRoom", adminRoomDao.searchRoom(keyWord));
		return "admin/selectRoom";
	}
}
