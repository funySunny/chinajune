package com.ChargePoint.bean;

public class ChargePointHome {
	private String c_p_id;//充电桩编号
	private String c_p_type;//充电桩类型   0-直流(DC)，1-交流(AC)
	private String w;//桩功率
	private String e_price;//电价
	private String is_free;//是否空闲	0-空闲，1-占用，2-被预约	
	private String time_count;//心跳时发送DTU编号（8）
	private String total_degree;		//最高输出电压（V）
	private String place;		//位置
	private String location;		//坐标（经纬度）
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public String getC_p_type() {
		return c_p_type;
	}
	public void setC_p_type(String c_p_type) {
		this.c_p_type = c_p_type;
	}
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	public String getE_price() {
		return e_price;
	}
	public void setE_price(String e_price) {
		this.e_price = e_price;
	}
	public String getTime_count() {
		return time_count;
	}
	public void setTime_count(String time_count) {
		this.time_count = time_count;
	}
	public String getTotal_degree() {
		return total_degree;
	}
	public void setTotal_degree(String total_degree) {
		this.total_degree = total_degree;
	}
	public String getIs_free() {
		return is_free;
	}
	public void setIs_free(String is_free) {
		this.is_free = is_free;
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
	@Override
	public String toString() {
		return "ChargePointHome [c_p_id=" + c_p_id + ", c_p_type=" + c_p_type + ", w=" + w + ", e_price=" + e_price
				+ ", is_free=" + is_free + ", time_count=" + time_count + ", total_degree=" + total_degree + ", place="
				+ place + ", location=" + location + "]";
	}

}
