package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Test;

@Repository("adminTestDao")
@Mapper
public interface AdminTestDao {

	public List<Test> selectTestByKwargs(Test test); // ²éÑ¯¿¼ÊÔ

	public void addTest(Test test); // Ìí¼Ó¿¼ÊÔ

	public void deleteTestByTest_id(Integer test_id); // Í¨¹ıidÉ¾³ı¿¼ÊÔ

	public void updateTest(Test test); // ĞŞ¸Ä¿¼ÊÔ
	
	public List<Test> selectRepeatedTest(Test test); // ²éÑ¯ÖØ¸´µÄ¿¼ÊÔ

}
