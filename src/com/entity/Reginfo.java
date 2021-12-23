package com.entity;

public class Reginfo {

	private Integer reginfo_id; // 报名信息id
	private Integer user_id; // 用户id
	private Integer room_id; // 考场id
	private Integer testinfo__room_id; // 关联id
	private String ticketnum; // 准考证号
	private Integer status; // 状态（0为未支付，1为已支付，2为考生主动取消，3为支付超时取消）
	private String submit_time; // 提交时间
	// ----------查询用----------
	private String uname; // 考生名
	private Integer testinfo_id; // 已发布考试id
	private String tname; // 考试名
	private String test_time; // 考试时间
	private String rname; // 考场名
	private String raddress; // 考场地址
	// ----------换考场用----------
	private Integer oldTestinfo__room_id; // 旧考场的id

	public Integer getReginfo_id() {
		return reginfo_id;
	}

	public void setReginfo_id(Integer reginfo_id) {
		this.reginfo_id = reginfo_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public Integer getTestinfo__room_id() {
		return testinfo__room_id;
	}

	public void setTestinfo__room_id(Integer testinfo__room_id) {
		this.testinfo__room_id = testinfo__room_id;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getTestinfo_id() {
		return testinfo_id;
	}

	public void setTestinfo_id(Integer testinfo_id) {
		this.testinfo_id = testinfo_id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTest_time() {
		return test_time;
	}

	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRaddress() {
		return raddress;
	}

	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}

	public Integer getOldTestinfo__room_id() {
		return oldTestinfo__room_id;
	}

	public void setOldTestinfo__room_id(Integer oldTestinfo__room_id) {
		this.oldTestinfo__room_id = oldTestinfo__room_id;
	}

}
