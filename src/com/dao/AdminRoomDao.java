package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Room;

@Repository("adminRoomDao")
@Mapper
public interface AdminRoomDao {

	public List<Room> selectRoomByKwargs(Room room); // 查询考场

	public void addRoom(Room room); // 添加考场

	public void deleteRoomByRoom_id(Integer room_id); // 通过id删除考场

	public void updateRoom(Room room); // 修改考场

	public List<Room> selectRepeatedRoom(Room room); // 查询重复的考场

	public List<Room> selectRoomFuzzily(Room room); // 模糊查询考场

}
