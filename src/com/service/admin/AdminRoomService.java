package com.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Room;

public interface AdminRoomService {
	public String selectRoom(Model model);		// 查询全部考场
	public String addRoom(Room room, Model model, HttpSession session);		// 添加考场
	public String deleteRoomById(Integer id, Model model, HttpSession session);		// 通过id删除考场
	public String toUpdateRoom(Integer id, Model model);		// 前往修改考场页
	public String updateRoom(Room room, Model model, HttpSession session);		// 修改考场
	public String searchRoom(String keyWord, Model model);		// 模糊查询
}
