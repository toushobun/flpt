package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Reginfo;
import com.entity.Testinfo;
import com.entity.Testinfo__Room;

@Repository("UserReginfoDao")
@Mapper
public interface UserReginfoDao {
	public List<Testinfo> userSelectTestinfo();		// 查询全部已发布考试
	public List<Testinfo__Room> userSelectTestinfo__Room(Integer testinfo_id);		// 查询该考试的考场
	public int userAddReginfo(Reginfo reginfo);		// 考生提交报名考试
	public List<Reginfo> userSelectReginfoByTicketnum(String ticketnum);		// 搜索是否有重复准考证
}
