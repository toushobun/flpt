package com.service.admin;

import org.springframework.ui.Model;

import com.entity.TestinfoRoom;

public interface AdminTestinfoRoomService {

	String selectTestinfoRoom(Integer testinfo_id, Model model); // 查询某个已发布考试的具体考场

	String toAddTestinfoRoom(TestinfoRoom testinfoRoom, Model model); // 前往配置考场页

	String cancelRoom(TestinfoRoom testinfoRoom, Model model); // 取消考场

	String addTestinfoRoom(TestinfoRoom testinfoRoom, Model model); // 新增考场

	String changeQuota(TestinfoRoom testinfoRoom, Model model); // 修改考场名额

}
