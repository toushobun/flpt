package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Buser;
import com.entity.Notice;

@Repository("userDao")
@Mapper
public interface UserDao {

	public List<Buser> selectBuserByKwargs(Buser buser);

	public void register(Buser buser);

	public List<Notice> selectNoticeByKwargs(Notice notice);

}
