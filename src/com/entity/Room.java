package com.entity;

public class Room {
	private Integer id;			// 考场id
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
