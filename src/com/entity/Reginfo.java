package com.entity;

public class Reginfo {
	private Integer reginfo_id;				// 报名信息id
	private Integer user_id;			// 用户id
	private Integer testinfo_id;		// 已发布考试id
	private Integer room_id;		// 考场id
	private String ticketnum;		// 准考证号
	private Integer status;			// 状态（0为未支付，1为已支付，2为考生主动取消，3为支付超时取消）
	private String submit_time;		// 提交时间
	// ----------查询用----------
	private Integer testinfo__room_id;	
	public Integer getUser_id() {
		return user_id;
	}
	public Integer getReginfo_id() {
		return reginfo_id;
	}
	public void setReginfo_id(Integer reginfo_id) {
		this.reginfo_id = reginfo_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getTestinfo_id() {
		return testinfo_id;
	}
	public void setTestinfo_id(Integer testinfo_id) {
		this.testinfo_id = testinfo_id;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public String getTicketnum() {
		return ticketnum;
	}
	public void setTicketnum(String ticketnum) {
		this.ticketnum = ticketnum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}
	public Integer getTestinfo__room_id() {
		return testinfo__room_id;
	}
	public void setTestinfo__room_id(Integer testinfo__room_id) {
		this.testinfo__room_id = testinfo__room_id;
	}
	
}
