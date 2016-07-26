package com.ChargePoint.bean;

public class Sale {
	private String c_p_id;
	private String place;
	private String location;
	private String saled_time;
	private String company_name;
	private String no;
	
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public String getSaled_time() {
		if(null != saled_time && -1 != saled_time.lastIndexOf(".")){
			return saled_time.substring(0,saled_time.lastIndexOf("."));
		}else{
			return saled_time;
		}
	}
	
	public void setSaled_time(String saled_time) {
		this.saled_time = saled_time;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Sale [c_p_id=" + c_p_id + ", place=" + place + ", location=" + location + ", saled_time=" + saled_time
				+ ", company_name=" + company_name + ", no=" + no + "]";
	}
	
}
