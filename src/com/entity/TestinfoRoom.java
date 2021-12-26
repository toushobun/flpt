package com.entity;

public class TestinfoRoom {

	private Integer testinfoRoom_id; // 关联id
	private Integer testinfo_id; // 已发布考试id
	private Integer room_id; // 考场id
	private Integer rquota; // 考试名额
	// ----------报名用----------
	private Integer status; // 状态，1可报名，0名额已满，-1不在报名时间，-2名额已满且不在报名时间
	// ----------查询用----------
	private String rname; // 考场名
	private String raddress; // 考场地址
	private String rtelnum; // 考场联系电话
	private String rpostcode; // 邮编
	private String test_time; // 考试时间
	private String regist_start_time; // 报名开始时间
	private String regist_end_time; // 报名截止时间
	private Double tprice; // 报名费用
	private Integer test_id; // 考试id
	private String tname; // 考试名
	private String tsubject; // 考试科目
	private String torganizer; // 主考单位

	private String[] rooms; // 考场名列表
	private Integer[] room_ids; // 考场id列表
	private Integer[] room_rquotas; // 考场名额列表

	public Integer getTestinfo_id() {
		return testinfo_id;
	}

	public Integer getTestinfoRoom_id() {
		return testinfoRoom_id;
	}

	public void setTestinfoRoom_id(Integer testinfoRoom_id) {
		this.testinfoRoom_id = testinfoRoom_id;
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

	public Integer getRquota() {
		return rquota;
	}

	public void setRquota(Integer rquota) {
		this.rquota = rquota;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getRtelnum() {
		return rtelnum;
	}

	public void setRtelnum(String rtelnum) {
		this.rtelnum = rtelnum;
	}

	public String getRpostcode() {
		return rpostcode;
	}

	public void setRpostcode(String rpostcode) {
		this.rpostcode = rpostcode;
	}

	public String getTest_time() {
		return test_time;
	}

	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}

	public String getRegist_start_time() {
		return regist_start_time;
	}

	public void setRegist_start_time(String regist_start_time) {
		this.regist_start_time = regist_start_time;
	}

	public String getRegist_end_time() {
		return regist_end_time;
	}

	public void setRegist_end_time(String regist_end_time) {
		this.regist_end_time = regist_end_time;
	}

	public Double getTprice() {
		return tprice;
	}

	public void setTprice(Double tprice) {
		this.tprice = tprice;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTsubject() {
		return tsubject;
	}

	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}

	public String getTorganizer() {
		return torganizer;
	}

	public void setTorganizer(String torganizer) {
		this.torganizer = torganizer;
	}

	public String[] getRooms() {
		return rooms;
	}

	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}

	public Integer[] getRoom_ids() {
		return room_ids;
	}

	public void setRoom_ids(Integer[] room_ids) {
		this.room_ids = room_ids;
	}

	public Integer[] getRoom_rquotas() {
		return room_rquotas;
	}

	public void setRoom_rquotas(Integer[] room_rquotas) {
		this.room_rquotas = room_rquotas;
	}

}
