package com.ChargePoint.bean;

public class ChargePointACLive2 {

	private String table_name;
	private Integer id;
	private String c_p_id;//充电桩编号
	private String time;// send protocal time
	private String v_out;		//电压输出值（V)
	private String i_out;//电流输出值（A）
	private String charged_time;		//累计充电时间（min）
	private String allow_charge;//充电机充电允许（<00>:=暂停；<01>：=允许）
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = "charge_point_live_"+table_name;
	}
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public String getV_out() {
		return v_out;
	}
	public void setV_out(String v_out) {
		this.v_out = v_out;
	}
	public String getI_out() {
		return i_out;
	}
	public void setI_out(String i_out) {
		this.i_out = i_out;
	}
	public String getCharged_time() {
		return charged_time;
	}
	public void setCharged_time(String charged_time) {
		this.charged_time = charged_time;
	}
	public String getAllow_charge() {
		return allow_charge;
	}
	public void setAllow_charge(String allow_charge) {
		this.allow_charge = allow_charge;
	}
	@Override
	public String toString() {
		return "ChargePointACLive2 [table_name=" + table_name + ", id=" + id + ", c_p_id=" + c_p_id + ", time=" + time
				+ ", v_out=" + v_out + ", i_out=" + i_out + ", charged_time=" + charged_time + ", allow_charge="
				+ allow_charge + "]";
	}
}
