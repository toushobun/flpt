package com.service.user;

import org.springframework.ui.Model;

import com.entity.Reginfo;

public interface UserReginfoService {

	public String selectReginfo(Integer user_id, Model model); // 查询全部报名信息

	public String addReginfo(Reginfo reginfo, Model model); // 查询全部考试信息

	public String deleteReginfo(Reginfo reginfo, Model model); // 通过id删除准考证

	public String cancelReg(Reginfo reginfo, Model model); // 取消报名

	public String selectAReginfo(Reginfo reginfo, Model model); // 查询一个准考证

	public String searchReginfo(Reginfo reginfo, Model model); // 模糊搜索

}
