package com.ChargePoint.bean;

public class Company {
	private Integer id;
	private String name;
	private String owner;
	private String address;
	private Integer station_count;
	private Integer c_p_count;
	private Integer ac1_count;
	private Integer ac2_count;
	private Integer dc1_count;
	private Integer dc2_count;
	private Integer admin_count;
	private String reg_no;
	private String tel;
	private String profit;

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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStation_count() {
		return station_count;
	}

	public void setStation_count(Integer station_count) {
		this.station_count = station_count;
	}

	public Integer getC_p_count() {
		return c_p_count;
	}

	public void setC_p_count(Integer c_p_count) {
		this.c_p_count = c_p_count;
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

	public Integer getAdmin_count() {
		return admin_count;
	}

	public void setAdmin_count(Integer admin_count) {
		this.admin_count = admin_count;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", owner=" + owner + ", address=" + address + ", station_count="
				+ station_count + ", c_p_count=" + c_p_count + ", ac1_count=" + ac1_count + ", ac2_count=" + ac2_count
				+ ", dc1_count=" + dc1_count + ", dc2_count=" + dc2_count + ", admin_count=" + admin_count + ", reg_no="
				+ reg_no + ", tel=" + tel + ", profit=" + profit + "]";
	}

}
