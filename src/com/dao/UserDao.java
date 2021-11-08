package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Buser;

@Repository("userDao")
@Mapper
public interface UserDao {
	
	public List<Buser> login(Buser buser);		// 验证用户登录信息
	public int register(Buser buser);		// 注册
	public List<Buser> selectBuserByUidnum(String uidnum);		// 查看该手机号是否已注册
	
}
