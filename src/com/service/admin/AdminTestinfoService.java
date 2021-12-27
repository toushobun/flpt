package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Testinfo;
import com.entity.TestinfoRoom;

public interface AdminTestinfoService {

	public String selectTestinfo(Model model); // 查询全部考试信息

	public String toAddTestinfo(TestinfoRoom testinfoRoom, Model model);// 前往添加考试信息页

	public String toAddTestinfoRoom(TestinfoRoom testinfoRoom, Model model); // 前往配置考场

	public String addTestinfo(TestinfoRoom testinfoRoom, Model model); // 添加考试信息

	public String deleteTestinfo(Integer testinfo_id, Model model); // 通过id删除考试信息

	public String toUpdateTestinfo(Integer testinfo_id, Model model); // 前往修改考试信息页

	public String updateTestinfo(Testinfo testinfo, Model model); // 修改考试信息

	public String searchTestinfo(Testinfo testinfo, Model model); // 模糊搜索

}
