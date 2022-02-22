package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Notice;

@Repository("noticeDao")
@Mapper
public interface NoticeDao {

	public List<Notice> selectNoticeByKwargs(Notice notice); // 查询公告

	public void addNotice(Notice notice); // 添加公告

	public void deleteNoticeByNotice_id(Integer notice_id); // 通过id删除公告

}
