package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.TestinfoRoom;

@Repository("testinfoRoomDao")
@Mapper
public interface TestinfoRoomDao {

	List<TestinfoRoom> selectTestinfoRoomByKwargs(TestinfoRoom TestinfoRoom); // 查询某个已发布考试的具体考场

	void updateTestinfoRoom(TestinfoRoom testinfoRoom); // 修改考场名额

	void deleteTestinfoRoomByTestinfoRoom_id(Integer testinfoRoom_id); // 取消考场

	void addTestinfoRoom(TestinfoRoom testinfoRoom); // 添加新考场
}
