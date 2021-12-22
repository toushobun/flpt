package com.entity;

public class Buser {
	
	private Integer user_id; // 考生id
	private String uidnum; // 身份证号码
	private String upwd; // 密码
	private String uname; // 考生姓名
	private String uidphoto; // 证件照片
	// ----------修改密码用----------
	private String newUpwd; // 新密码

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public String getNewUpwd() {
		return newUpwd;
	}

	public void setNewUpwd(String newUpwd) {
		this.newUpwd = newUpwd;
	}

}
