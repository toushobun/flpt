package com.service.user;

import org.springframework.ui.Model;

import com.entity.Reginfo;

public interface UserReginfoService {

	public String selectReginfo(Integer user_id, Model model); // 查询全部报名信息

	public String addReginfo(Reginfo reginfo, Model model); // 查询全部考试信息

	public String deleteReginfo(Integer reginfo_id, Model model); // 通过id删除准考证

	public String toChangeRoom(Integer reginfo_id, Model model); // 前往修改考场页

	public String changeRoom(Reginfo reginfo, Model model); // 修改考场

	public String cancelReg(Integer reginfo_id, Model model); // 取消报名

	public String selectAReginfo(Reginfo reginfo, Model model); // 查询一个准考证

	public String searchReginfo(Reginfo reginfo, Model model); // 模糊搜索

	public String toPay(Integer reginfo_id, Model model); // 前往付款页

	public String pay(Integer reginfo_id, Model model); // 付款

	public String createTicket(Integer reginfo_id, Model model); // 生成准考证

}
