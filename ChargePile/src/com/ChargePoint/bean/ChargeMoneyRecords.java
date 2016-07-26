package com.ChargePoint.bean;

public class ChargeMoneyRecords {
	
	private Integer id;
	private String user_name;
	private String left_money;
	private String time;		
	private Float pass;
	private Float total_pass;
	private String type;
	private String card_id;
	private String place;
	private String trade_no;
	private Integer total_count;//累计充值次数
	
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
	public String getLeft_money() {
		return left_money;
	}
	public void setLeft_money(String left_money) {
		this.left_money = left_money;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Float getPass() {
		return pass;
	}
	public void setPass(float pass) {
		this.pass = pass;
	}
	public Float getTotal_pass() {
		return total_pass;
	}
	public void setTotal_pass(float total_pass) {
		this.total_pass = total_pass;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public Integer getTotal_count() {
			return total_count;
	}
	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}
	@Override
	public String toString() {
		return "ChargeMoneyRecords [id=" + id + ", user_name=" + user_name + ", left_money=" + left_money + ", time="
				+ time + ", pass=" + pass + ", total_pass=" + total_pass + ", type=" + type + ", card_id=" + card_id
				+ ", place=" + place + ", trade_no=" + trade_no + ", total_count=" + total_count + "]";
	}
	
}
