package com.service.admin;

import org.springframework.ui.Model;

import com.entity.Reginfo;

public interface AdminReginfoService {

	public String selectReginfo(Model model); // 查询全部准考证

	public String deleteReginfo(Integer reginfo_id, Model model); // 通过id删除准考证

	public String searchReginfo(Reginfo reginfo, Model model); // 模糊搜索

}
