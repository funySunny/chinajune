package com.ChargePoint.bean;

public class DataExchange {
	
	private Integer id;
	private String c_p_id;
	private String time;
	private String version;
	private String battery_type;
	private String capacity_called;
	private String vtotal_rated;
	private String vendor;
	private String product_time;
	private int charge_count;//充电次数
	private String tag;
	private String vin;
	private String software_version;
	private String v_cell_allow;
	private String i_total_allow;
	private String energy_called;
	private String v_total_allow;
	private String t_allow;
	private String soc_start;
	private String v_total_start;
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBattery_type() {
		return battery_type;
	}
	public void setBattery_type(String battery_type) {
		this.battery_type = battery_type;
	}
	public String getCapacity_called() {
		return capacity_called;
	}
	public void setCapacity_called(String capacity_called) {
		this.capacity_called = capacity_called;
	}
	public String getVtotal_rated() {
		return vtotal_rated;
	}
	public void setVtotal_rated(String vtotal_rated) {
		this.vtotal_rated = vtotal_rated;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getProduct_time() {
		return product_time;
	}
	public void setProduct_time(String product_time) {
		this.product_time = product_time;
	}
	public int getCharge_count() {
		return charge_count;
	}
	public void setCharge_count(int charge_count) {
		this.charge_count = charge_count;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getSoftware_version() {
		return software_version;
	}
	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}
	public String getV_cell_allow() {
		return v_cell_allow;
	}
	public void setV_cell_allow(String v_cell_allow) {
		this.v_cell_allow = v_cell_allow;
	}
	public String getI_total_allow() {
		return i_total_allow;
	}
	public void setI_total_allow(String i_total_allow) {
		this.i_total_allow = i_total_allow;
	}
	public String getEnergy_called() {
		return energy_called;
	}
	public void setEnergy_called(String energy_called) {
		this.energy_called = energy_called;
	}
	public String getV_total_allow() {
		return v_total_allow;
	}
	public void setV_total_allow(String v_total_allow) {
		this.v_total_allow = v_total_allow;
	}
	public String getT_allow() {
		return t_allow;
	}
	public void setT_allow(String t_allow) {
		this.t_allow = t_allow;
	}
	public String getSoc_start() {
		return soc_start;
	}
	public void setSoc_start(String soc_start) {
		this.soc_start = soc_start;
	}
	public String getV_total_start() {
		return v_total_start;
	}
	public void setV_total_start(String v_total_start) {
		this.v_total_start = v_total_start;
	}
	@Override
	public String toString() {
		return "DataExchange [id=" + id + ", c_p_id=" + c_p_id + ", time=" + time + ", version=" + version
				+ ", battery_type=" + battery_type + ", capacity_called=" + capacity_called + ", vtotal_rated="
				+ vtotal_rated + ", vendor=" + vendor + ", product_time=" + product_time + ", charge_count="
				+ charge_count + ", tag=" + tag + ", vin=" + vin + ", software_version=" + software_version
				+ ", v_cell_allow=" + v_cell_allow + ", i_total_allow=" + i_total_allow + ", energy_called="
				+ energy_called + ", v_total_allow=" + v_total_allow + ", t_allow=" + t_allow + ", soc_start="
				+ soc_start + ", v_total_start=" + v_total_start + "]";
	}
	
}
