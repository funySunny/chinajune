package com.ChargePoint.bean;

public class ChargeMoneyRecords2 {
	
	private String table_name;
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
	
	public String getTable_name() {
		return table_name;
	}
	/**
	 * @param table_name "charge_money_records_"+table_name;
	 */
	public void setTable_name(String table_name) {
		this.table_name = "charge_money_records_"+table_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the left_money
	 */
	public String getLeft_money() {
		return left_money;
	}
	/**
	 * @param left_money the left_money to set
	 */
	public void setLeft_money(String left_money) {
		this.left_money = left_money;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the pass
	 */
	public Float getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(float pass) {
		this.pass = pass;
	}
	/**
	 * @return the total_pass
	 */
	public Float getTotal_pass() {
		return total_pass;
	}
	/**
	 * @param total_pass the total_pass to set
	 */
	public void setTotal_pass(float total_pass) {
		this.total_pass = total_pass;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the card_id
	 */
	public String getCard_id() {
		return card_id;
	}
	/**
	 * @param card_id the card_id to set
	 */
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * @return the trade_no
	 */
	public String getTrade_no() {
		return trade_no;
	}
	/**
	 * @param trade_no the trade_no to set
	 */
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	/**
	 * @return the total_count
	 */
	public Integer getTotal_count() {
			return total_count;
	}
	/**
	 * @param total_count the total_count to set
	 */
	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}
	@Override
	public String toString() {
		return "ChargeMoneyRecords2 [table_name=" + table_name + ", id=" + id + ", user_name=" + user_name
				+ ", left_money=" + left_money + ", time=" + time + ", pass=" + pass + ", total_pass=" + total_pass
				+ ", type=" + type + ", card_id=" + card_id + ", place=" + place + ", trade_no=" + trade_no
				+ ", total_count=" + total_count + "]";
	}
	
}
