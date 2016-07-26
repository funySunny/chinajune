package com.ChargePoint.bean;

import java.util.List;

public class ChargePointStation {

	private Integer id;
	private String name;
	private String c_p_id;
	private String place;
	private String location;
	private Integer c_p_count;
	private Integer c_p_free_count;
	private Integer ac1_count;
	private Integer ac2_count;
	private Integer dc1_count;
	private Integer dc2_count;
	private String start_time;
	private String end_time;
	private String parking_fee;
	private String service_fee;
	private String other_introduce;
	private String picture;
	
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public Integer getC_p_count() {
		return c_p_count;
	}
	public void setC_p_count(Integer c_p_count) {
		this.c_p_count = c_p_count;
	}
	public Integer getC_p_free_count() {
		return c_p_free_count;
	}
	public void setC_p_free_count(Integer c_p_free_count) {
		this.c_p_free_count = c_p_free_count;
	}
	public Integer getAc1_count() {
		return ac1_count;
	}
	public void setAc1_count(Integer ac1_count) {
		this.ac1_count = ac1_count;
	}
	public Integer getAc2_count() {
		return ac2_count;
	}
	public void setAc2_count(Integer ac2_count) {
		this.ac2_count = ac2_count;
	}
	public Integer getDc1_count() {
		return dc1_count;
	}
	public void setDc1_count(Integer dc1_count) {
		this.dc1_count = dc1_count;
	}
	public Integer getDc2_count() {
		return dc2_count;
	}
	public void setDc2_count(Integer dc2_count) {
		this.dc2_count = dc2_count;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getParking_fee() {
		return parking_fee;
	}
	public void setParking_fee(String parking_fee) {
		this.parking_fee = parking_fee;
	}
	public String getService_fee() {
		return service_fee;
	}
	public void setService_fee(String service_fee) {
		this.service_fee = service_fee;
	}
	public String getOther_introduce() {
		return other_introduce;
	}
	public void setOther_introduce(String other_introduce) {
		this.other_introduce = other_introduce;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "ChargePointStation [id=" + id + ", name=" + name + ", c_p_id=" + c_p_id + ", place=" + place
				+ ", location=" + location + ", c_p_count=" + c_p_count + ", c_p_free_count=" + c_p_free_count
				+ ", ac1_count=" + ac1_count + ", ac2_count=" + ac2_count + ", dc1_count=" + dc1_count + ", dc2_count="
				+ dc2_count + ", start_time=" + start_time + ", end_time=" + end_time + ", parking_fee=" + parking_fee
				+ ", other_introduce=" + other_introduce + ", picture=" + picture + "]";
	}

}
