package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Reginfo;
import com.entity.Testinfo;
import com.entity.Testinfo__room;

@Repository("UserReginfoDao")
@Mapper
public interface UserReginfoDao {
	
	public List<Testinfo> userSelectTestinfo();		// 查询全部已发布考试
	public List<Testinfo> userSelectReginfoByTestinfo_id(Integer testinfo__id);		// 查看该考生是否已报名此考试
	public List<Testinfo__room> userSelectTestinfo__room(Integer testinfo_id);		// 查询该考试的考场
	public int userAddReginfo(Reginfo reginfo);		// 考生提交报名考试
	public List<Reginfo> userSelectReginfoByTicketnum(String ticketnum);		// 搜索是否有重复准考证
	public Testinfo__room userSelectTestinfo__roomByTestinfo__room_id(Integer testinfo__room_id);		// 通过testinfo_id查找一个考场关联表
	public Reginfo userSelectAReginfoByUser_idAndTestinfo_id(Reginfo reginfo);		// 搜索一个准考证
	public Reginfo userSelectAReginfoByReginfo_id(Integer reginfo_id);		// 搜索一个准考证
	public int userUpdateReginfo(Reginfo reginfo);		// 修改准考证（状态）
	public int userDeleteReginfoByReginfo_id(Integer reginfo_id);		// 取消报名
	public List<Reginfo> userSelectReginfoByUser_id(Integer user_id);		// 用户查看准考证表
	
}
