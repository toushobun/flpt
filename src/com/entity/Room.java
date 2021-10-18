package com.entity;

public class Room {
	private Integer room_id;			// 考场id
	private String rname;		// 考场名
	private String raddress;	// 考场地址
	private String rtelnum;		// 考场联系电话
	private String rpostcode;	// 邮编
	public String getRname() {
		return rname;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
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
