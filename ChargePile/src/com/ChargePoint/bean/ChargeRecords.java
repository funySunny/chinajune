package com.ChargePoint.bean;

public class ChargeRecords {
	private Integer id;		
	private String user_name;
	private String c_p_id;
	private String start_time;		
	private String end_time;
	private String time_count;// total time
	private Float degree; //度数
	private Float total_degree;//累计充电
	private Integer total_count;//累计充电次数
	private String place;//充电位置
	private Float money;//充电花费金额
	private String trade_no;
	private String trade_status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public String getStart_time() {
		if(null != start_time && -1 != start_time.lastIndexOf("."))
		{
			return start_time.substring(0,start_time.lastIndexOf("."));
		}else{
			return start_time;
		}
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		if(null != end_time && -1 != end_time.lastIndexOf("."))
		{
			return end_time.substring(0,end_time.lastIndexOf("."));
		}else{
			return end_time;
		}
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getTime_count() {
		return time_count;
	}
	public void setTime_count(String time_count) {
		this.time_count = time_count;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public Float getDegree() {
		return degree;
	}
	public void setDegree(Float degree) {
		this.degree = degree;
	}
	public Float getTotal_degree() {
		return total_degree;
	}
	public void setTotal_degree(Float total_degree) {
		this.total_degree = total_degree;
	}
	public Integer getTotal_count() {
		return total_count;
	}
	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	@Override
	public String toString() {
		return "ChargeRecords [id=" + id + ", user_name=" + user_name + ", c_p_id=" + c_p_id + ", start_time="
				+ start_time + ", end_time=" + end_time + ", time_count=" + time_count + ", degree=" + degree
				+ ", total_degree=" + total_degree + ", total_count=" + total_count + ", place=" + place + ", money="
				+ money + ", trade_no=" + trade_no + ", trade_status=" + trade_status + "]";
	}
	
}
