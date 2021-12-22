package com.dao;

import java.util.List;

import com.entity.Notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("adminNoticeDao")
@Mapper
public interface AdminNoticeDao {
	
	public int addNotice(Notice notice); // 添加新公告

	public int deleteNoticeByNotice_id(Integer notice_id); // 通过id删除一个公告

	public Notice selectANoticeByNotice_id(Integer notice_id); // 查询某个公告的详细信息

	public List<Notice> selectNotice(); // 查询全部公告

}
