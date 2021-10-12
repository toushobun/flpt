package com.service.admin;

import javax.servlet.http.HttpSession;

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
	public String addRoom(Room room, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		if(adminRoomDao.selectARoomByRname(room.getRname()).size() > 0) {
			model.addAttribute("msg", "添加失败！该考场名已存在！");
			return "admin/addRoom";
		}
		if(adminRoomDao.addRoom(room) > 0) {
			session.setAttribute("allRoom", adminRoomDao.selectRoom());
			model.addAttribute("msg", "添加成功！");
		}
		// 这个指令将转到controller层验证
		return "forward:/adminRoom/selectRoom";
	}

	@Override
	public String deleteRoomById(Integer id, Model model, HttpSession session) {
		// TODO Auto-generated method stub
//		if(adminRoomDao.selectARoomById(id).getStatus() != 0) {
//			model.addAttribute("msg", "该考场已被占用已发布，不允许删除！");
//			return "forward:/adminRoom/selectRoom";
//		}
		if(adminRoomDao.deleteRoomById(id) > 0) {
			session.setAttribute("allRoom", adminRoomDao.selectRoom());
			model.addAttribute("msg", "删除成功！");
		}
		return "forward:/adminRoom/selectRoom";
	}

	@Override
	public String toUpdateRoom(Integer id, Model model) {
		// TODO Auto-generated method stub
		Room room = adminRoomDao.selectARoomById(id); 
		model.addAttribute(room);
		return "admin/updateRoom";
	}

	@Override
	public String updateRoom(Room room, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		if(adminRoomDao.selectARoomByRnameAndId(room).size() > 0) {
			model.addAttribute("msg", "修改失败！该考场名已存在！");
			// 把原来的Rname传回前端
			room.setRname(adminRoomDao.selectARoomById(room.getId()).getRname());
			model.addAttribute("room", room);
			return "admin/updateRoom";
		}
		if(adminRoomDao.updateRoom(room) > 0) {
			session.setAttribute("allRoom", adminRoomDao.selectRoom());
			model.addAttribute("msg", "修改成功！");
		}
		return "forward:/adminRoom/selectRoom";
	}
}
