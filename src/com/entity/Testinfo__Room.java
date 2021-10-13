package com.entity;

public class Testinfo__Room {
	private Integer id;					// 关联id
	private Integer testinfo_id;				// 已发布考试id
	private Integer room_id;				// 考场id
	private Integer rquota;				// 考试名额
	// ----------查询用----------
	private String rname;		// 考场名
	private String raddress;	// 考场地址
	private String rtelnum;		// 考场联系电话
	private String rpostcode;	// 邮编
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getRquota() {
		return rquota;
	}
	public void setRquota(Integer rquota) {
		this.rquota = rquota;
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
	
}
