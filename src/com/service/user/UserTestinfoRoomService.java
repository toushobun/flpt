package com.service.user;

import org.springframework.ui.Model;

import com.entity.TestinfoRoom;

public interface UserTestinfoRoomService {

	String selectTestinfoRoom(TestinfoRoom testinfoRoom, Model model); // 查询某个已发布考试的具体考场

}
