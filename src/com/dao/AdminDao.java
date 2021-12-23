package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Auser;

@Repository("adminDao")
@Mapper
public interface AdminDao {

	public List<Auser> login(Auser auser); // 验证管理员登录信息

}
