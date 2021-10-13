package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Testinfo;
import com.entity.Testinfo__Room;

public interface AdminTestinfoService {
	public String selectTestinfo(Model model);		// 查询全部已发布考试
	public String toAddTestinfo(Model model);		// 前往发布考试页
	public String toAddTestinfoAboutRoom(Testinfo testinfo, Model model);		// 前往选择考场页
	public String addTestinfo(Testinfo testinfo, Model model);		// 添加已发布考试
	public String deleteTestinfoById(Integer id, Model model);		// 通过id删除已发布考试
	public String toUpdateTestinfo(Integer id, Model model);		// 前往修改已发布考试页
	public String updateTestinfo(Testinfo testinfo, Model model);		// 修改已发布考试
	public String selectTestinfoRoom(Integer testinfo_id, Model model);		// 前往详细考场页
	public String updateRoomQuota(Testinfo__Room testinfo__Room, Model model);		// 更新考场名额
	public String cancelRoom(Testinfo__Room testinfo__Room, Model model);		// 取消考场
}
