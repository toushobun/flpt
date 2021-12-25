package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.entity.Testinfo;

@Repository("adminTestinfoDao")
@Mapper
public interface AdminTestinfoDao {

	public List<Testinfo> selectTestinfoByKwargs(Testinfo testinfo); // 查询考试信息

	public void addTestinfo(Testinfo testinfo); // 添加考试信息

	public void deleteTestinfoByTestinfo_id(Integer testinfo_id); // 通过id删除考试信息

	public void updateTestinfo(Testinfo testinfo); // 修改考试信息

	public List<Testinfo> selectTestinfoFuzzily(Testinfo testinfo); // 模糊查询考试信息

	// 以下为操作考试发布信息中的考场信息

	public String selectTestinfoRoom(String testinfo_id, Model model); // 查询该考试信息的全部考场
}
