package com.ChargePoint.bean;

public class OperateResults {
	
	private Integer id;
	private String operation_result;
	private String back_time;
	private String result_details;		
	private String failure_case;
	private String c_p_id;
	private String user_id;
	private String is_send;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOperation_result() {
		return operation_result;
	}
	public void setOperation_result(String operation_result) {
		this.operation_result = operation_result;
	}
	public String getBack_time() {
		return back_time;
	}
	public void setBack_time(String back_time) {
		this.back_time = back_time;
	}
	public String getResult_details() {
		return result_details;
	}
	public void setResult_details(String result_details) {
		this.result_details = result_details;
	}
	public String getFailure_case() {
		return failure_case;
	}
	public void setFailure_case(String failure_case) {
		this.failure_case = failure_case;
	}
	public String getC_p_id() {
		return c_p_id;
	}
	public void setC_p_id(String c_p_id) {
		this.c_p_id = c_p_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getIs_send() {
		return is_send;
	}
	public void setIs_send(String is_send) {
		this.is_send = is_send;
	}
	@Override
	public String toString() {
		return "OperateResults [id=" + id + ", operation_result=" + operation_result + ", back_time=" + back_time
				+ ", result_details=" + result_details + ", failure_case=" + failure_case + ", c_p_id=" + c_p_id
				+ ", user_id=" + user_id + ", is_send=" + is_send + "]";
	}
	
}
