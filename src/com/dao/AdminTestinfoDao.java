package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Reginfo;
import com.entity.Testinfo;
import com.entity.Testinfo__Room;

@Repository("adminTestinfoDao")
@Mapper
public interface AdminTestinfoDao {
	public List<Testinfo> selectTestinfo();		// 查询全部已发布考试
	public int addTestinfo(Testinfo testinfo);		// 发布考试
	public int addTestinfo__room(Testinfo__Room testinfo_Room);	//添加对应考试的考场
	public int deleteTestinfoByTestinfo_id(Integer testinfo_id);		// 通过id删除已发布考试
	public List<Testinfo__Room> selectTestinfo__RoomByTestinfo_id(Integer testinfo_id);		// 通过testinfo_id搜索关联
	public int deleteTestinfo__RoomByTestinfo__room_id(Integer testinfo__room_id);		// 通过id删除关联
	public Testinfo selectATestinfoByTestinfo_id(Integer testinfo_id);		// 通过id搜索一个已发布考试（为了前往已发布考试页）
	public Testinfo selectATestinfoByTest_id(Integer test_id);		// 通过testinfo_id搜索一个已发布考试
	public int updateTestinfo(Testinfo testinfo);		//修改已发布考试
	public int updateRoomQuota(Testinfo__Room testinfo__Room);		// 修改Room名额
	public List<Reginfo> selectAReginfoByRoom_id(Integer room_id);		// 查询是否有学生已经报名此考场
	public List<Reginfo> selectAReginfoByTestinfo_id(Integer testinfo_id);		//查询是否有学生已经报名此考试
	public List<Testinfo> searchTestinfo(String keyWord);		// 模糊查询
}
