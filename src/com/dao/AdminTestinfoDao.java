package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Testinfo;
import com.entity.Testinfo__Room;

@Repository("adminTestinfoDao")
@Mapper
public interface AdminTestinfoDao {
	public List<Testinfo> selectTestinfo();		// 查询全部已发布考试
	public int addTestinfo(Testinfo testinfo);		// 发布考试
	public int addTestinfo__room(Testinfo__Room testinfo_Room);	//添加对应考试的考场
	public int deleteTestinfoById(Integer id);		// 通过id删除已发布考试
	public List<Testinfo__Room> selectTestinfo__RoomByTestinfo_id(Integer testinfo_id);		// 通过testinfo_id搜索需要删除的关联
	public int deleteTestinfo__RoomById(Integer id);		// 通过id删除关联
	public Testinfo selectATestinfoById(Integer id);		// 通过id搜索一个已发布考试（为了前往已发布考试页）
	public Testinfo selectATestinfoByTest_id(Integer test_id);		// 通过test_id搜索一个已发布考试
	public int updateTestinfo(Testinfo testinfo);		//修改已发布考试
}
