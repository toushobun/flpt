package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Buser;

@Repository("adminBuserDao")
@Mapper
public interface AdminBuserDao {

	public List<Buser> selectBuserByKwargs(Buser buser); // 查询考生

	public void deleteBuserByUser_id(Integer user_id); // 通过id删除考生

	public List<Buser> selectBuserFuzzily(Buser buser); // 模糊查询考生

}
