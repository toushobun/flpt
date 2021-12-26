package com.entity;

public class Testinfo {

	private Integer testinfo_id; // 已发布考试id
	private Integer test_id; // 考试id
	private String test_time; // 考试时间
	private String regist_start_time; // 报名开始时间
	private String regist_end_time; // 报名截止时间
	private Double tprice; // 报名费用
	// ----------查询用----------
	private String tname; // 考试名
	private String tsubject; // 考试科目
	private String torganizer; // 主考单位
	// ----------报名用----------
	private Integer status; // 考生选择考场时判断是否已报名该考试

	public Integer getTest_id() {
		return test_id;
	}

	public Integer getTestinfo_id() {
		return testinfo_id;
	}

	public void setTestinfo_id(Integer testinfo_id) {
		this.testinfo_id = testinfo_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
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

	// ----------查询用----------
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
