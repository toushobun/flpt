package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository("userDao")
@Mapper
public interface UserDao {

	public List<User> selectUserByKwargs(User user); // 查询考生

	public void register(User user);

	public void deleteUserByUser_id(Integer user_id); // 通过id删除考生

	public List<User> selectUserFuzzily(User user); // 模糊查询考生
}
