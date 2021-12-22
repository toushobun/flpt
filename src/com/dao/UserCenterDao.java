package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Buser;

@Repository("userCenterDao")
@Mapper
public interface UserCenterDao {

	public Buser selectABuserByUser_id(Integer integer);

	public int updateBuser(Buser buser);

}
