package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Testinfo__room;

@Repository("adminTestinfoRoomDao")
@Mapper
public interface AdminTestinfoRoomDao {

	List<Testinfo__room> selectTestinfoRoomByKwargs(Testinfo__room Testinfo__room); // 查询某个已发布考试的具体考场
}
