package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Testinfo;

@Repository("UserReginfoDao")
@Mapper
public interface UserReginfoDao {
	public List<Testinfo> userSelectTestinfo();		// 查询全部已发布考试
}
