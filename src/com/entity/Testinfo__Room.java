package com.entity;

public class Testinfo__Room {
	private Integer id;					// 关联id
	private Integer testinfo_id;				// 已发布考试id
	private Integer room_id;				// 考场id
	private Integer rquota;				// 考试名额
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
	
}
