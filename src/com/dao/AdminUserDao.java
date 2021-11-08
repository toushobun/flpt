package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Buser;

@Repository("adminUserDao")
@Mapper

public interface AdminUserDao {
	
	public List<Buser> selectUser();		// 查询全部考生
	public int deleteUserByUser_id(Integer room_id);		// 通过id删除考生
	public List<Buser> searchUser(String keyWord);		// 模糊查询
	public List<Buser> selectReginfoByUser_id(Integer user_id);		// 搜索此考生是否已报名
	
}
