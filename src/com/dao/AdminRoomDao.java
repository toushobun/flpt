package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Room;

@Repository("adminRoomDao")
@Mapper
public interface AdminRoomDao {
	public List<Room> selectRoom();		// 查询全部考场
	public int addRoom(Room room);		// 添加考场
	public int deleteRoomById(Integer id);		// 通过id删除考场
	public Room selectARoomById(Integer id);		// 通过id搜索一个考场（为了前往考场页）
	public List<Room> selectARoomByRname(String rname);		// 通过Rname搜索一个考场（为了新增时查重）
	public List<Room> selectARoomByRnameAndId(Room room);		// 通过Rname和Id搜索一个考场（为了查重）
	public int updateRoom(Room room);		//修改考场
	public List<Room> selectATestinfo__RoomByRoom_id(Integer room_id);		// 通过Room_id搜索关联
	public List<Room> searchRoom(String keyWord);		// 模糊查询
	public List<Room> selectRoomByTestinfo_id(Integer testinfo_id);		// 查询未被选的考场
}
