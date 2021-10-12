package com.entity;

public class Buser {
	private Integer id;			// 考生id
	private String uidnum;		// 身份证号码
	private String upwd;		// 密码
	private String uname;		// 考生姓名
	private String uidphoto;	// 证件照片
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUidnum() {
		return uidnum;
	}
	public void setUidnum(String uidnum) {
		this.uidnum = uidnum;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUidphoto() {
		return uidphoto;
	}
	public void setUidphoto(String uidphoto) {
		this.uidphoto = uidphoto;
	}
	
}
