package com.ChargePoint.bean;

public class ChargePoint {

	private String c_p_id;//充电桩编号
	private Integer station_id;//充电站编号
	private String c_p_type;//充电桩类型   0-直流(DC)，1-交流(AC)
	private String w;//桩功率
	private String e_price;//电价
	private String is_free;//是否空闲	0-空闲，1-被预约，2-充电中	
	private String dtu_id;//心跳时发送DTU编号（8）
	private String v_max_charge_out;		//最高输出电压（V）
	private String v_min_charge_out;//最低输出电压（V)
	private String i_max_charge_out;		//最大输出电流（A)
	private String i_min_charge_out;//最小输出电流（A）
	private String total_degree;//累计充电量（度）
	private String time_count;//累计充电时间
	private Integer available_count;//可用充电枪个数
	private String company_id;//公司id
	private String inner_no;//站内编号
	
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public Integer getStation_id() {
		return station_id;
	}
	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
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
	/**
	 * @return 是否空闲	0-空闲，1-被预约，2-充电中	
	 */
	public String getIs_free() {
		return is_free;
	}
	/**是否空闲	0-空闲，1-被预约，2-充电中	
	 * @param String is_free
	 */
	public void setIs_free(String is_free) {
		this.is_free = is_free;
	}
	public String getDtu_id() {
		return dtu_id;
	}
	public void setDtu_id(String dtu_id) {
		this.dtu_id = dtu_id;
	}
	
	public String getV_max_charge_out() {
		return v_max_charge_out;
	}
	public void setV_max_charge_out(String v_max_charge_out) {
		this.v_max_charge_out = v_max_charge_out;
	}
	public String getV_min_charge_out() {
		return v_min_charge_out;
	}
	public void setV_min_charge_out(String v_min_charge_out) {
		this.v_min_charge_out = v_min_charge_out;
	}
	public String getI_max_charge_out() {
		return i_max_charge_out;
	}
	public void setI_max_charge_out(String i_max_charge_out) {
		this.i_max_charge_out = i_max_charge_out;
	}
	public String getI_min_charge_out() {
		return i_min_charge_out;
	}
	public void setI_min_charge_out(String i_min_charge_out) {
		this.i_min_charge_out = i_min_charge_out;
	}
	public String getTotal_degree() {
		return total_degree;
	}
	public void setTotal_degree(String total_degree) {
		this.total_degree = total_degree;
	}
	public String getTime_count() {
		return time_count;
	}
	public void setTime_count(String time_count) {
		this.time_count = time_count;
	}
	public Integer getAvailable_count() {
		return available_count;
	}
	public void setAvailable_count(Integer available_count) {
		this.available_count = available_count;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getInner_no() {
		return inner_no;
	}
	public void setInner_no(String inner_no) {
		this.inner_no = inner_no;
	}
	@Override
	public String toString() {
		return "ChargePoint [c_p_id=" + c_p_id + ", station_id=" + station_id + ", c_p_type=" + c_p_type + ", w=" + w
				+ ", e_price=" + e_price + ", is_free=" + is_free + ", dtu_id=" + dtu_id + ", v_max_charge_out="
				+ v_max_charge_out + ", v_min_charge_out=" + v_min_charge_out + ", i_max_charge_out=" + i_max_charge_out
				+ ", i_min_charge_out=" + i_min_charge_out + ", total_degree=" + total_degree + ", time_count="
				+ time_count + ", available_count=" + available_count + ", company_id=" + company_id + ", inner_no="
				+ inner_no + "]";
	}
	
}
