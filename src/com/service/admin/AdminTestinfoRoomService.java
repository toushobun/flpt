package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Testinfo__room;

public interface AdminTestinfoRoomService {

	String selectTestinfoRoom(Testinfo__room testinfo__room, Model model); // 查询某个已发布考试的具体考场

}
