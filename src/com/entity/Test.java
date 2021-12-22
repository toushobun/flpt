package com.entity;

public class Test {

	private Integer test_id; // 考试id
	private String tname; // 考试名
	private String tsubject; // 考试科目
	private String torganizer; // 主考单位
	private Integer status; // 状态（是否已发布）

	public String getTname() {
		return tname;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
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
