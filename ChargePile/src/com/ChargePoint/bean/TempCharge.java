package com.ChargePoint.bean;

public class TempCharge {
	
	private Integer id;
	private String c_p_id;
	private String user_id;
	private Integer charger_no;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getCharger_no() {
		return charger_no;
	}
	public void setCharger_no(Integer charger_no) {
		this.charger_no = charger_no;
	}
	@Override
	public String toString() {
		return "TempCharge [id=" + id + ", c_p_id=" + c_p_id + ", user_id=" + user_id + ", charger_no=" + charger_no
				+ "]";
	}
}
