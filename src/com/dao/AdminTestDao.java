package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Test;

@Repository("adminTestDao")
@Mapper
public interface AdminTestDao {

	public List<Test> selectTest(); // 查询全部考试

	public int addTest(Test test); // 添加考试

	public int deleteTestByTest_id(Integer test_id); // 通过id删除考试

	public Test selectATestByTest_id(Integer test_id); // 通过id搜索一个考试（为了前往考试页）

	public List<Test> selectATestByTname(String tname); // 通过Tname搜索一个考试（为了新增时查重）

	public List<Test> selectATestByTnameAndTest_id(Test test); // 通过Tname和Id搜索一个考试（为了查重）

	public int updateTest(Test test); // 修改考试

	public List<Test> searchTest(String keyWord); // 模糊搜索

}
