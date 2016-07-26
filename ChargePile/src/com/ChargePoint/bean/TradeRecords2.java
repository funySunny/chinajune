package com.ChargePoint.bean;

public class TradeRecords2 {
	
	private String table_name;
	private Integer id;
	private String trade_no;
	private String trade_status;
	private String user_name;		
	private String body;
	private String time;
	private String money;
	private String type;
	
	public String getTable_name() {
		return table_name;
	}
	/**"trade_records_"+c_p_id
	 * @param c_p_id
	 */
	public void setTable_name(String c_p_id) {
		this.table_name = "trade_records_"+c_p_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TradeRecords2 [table_name=" + table_name + ", id=" + id + ", trade_no=" + trade_no + ", trade_status="
				+ trade_status + ", user_name=" + user_name + ", body=" + body + ", time=" + time + ", money=" + money
				+ ", type=" + type + "]";
	}
	
}
