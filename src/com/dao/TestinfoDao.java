package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Testinfo;

@Repository("testinfoDao")
@Mapper
public interface TestinfoDao {

	public List<Testinfo> selectTestinfoByKwargs(Testinfo testinfo); // 查询考试信息

	public void addTestinfo(Testinfo testinfo); // 添加考试信息

	public void deleteTestinfoByTestinfo_id(Integer testinfo_id); // 通过id删除考试信息

	public void updateTestinfo(Testinfo testinfo); // 修改考试信息

	public List<Testinfo> selectTestinfoFuzzily(Testinfo testinfo); // 模糊查询考试信息

}
