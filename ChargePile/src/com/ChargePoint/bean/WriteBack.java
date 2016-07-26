package com.ChargePoint.bean;

public class WriteBack {

	private Integer id;
	private Integer station_id;
	private String review_user_name;
	private String content;
	private String time;
	private String write_back_user_name;
	private Integer review_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStation_id() {
		return station_id;
	}
	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}
	public String getReview_user_name() {
		return review_user_name;
	}
	public void setReview_user_name(String review_user_name) {
		this.review_user_name = review_user_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		if(null != time && -1 != time.lastIndexOf("."))
		{
			return time.substring(0,time.lastIndexOf("."));
		}else{
			return time;
		}
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWrite_back_user_name() {
		return write_back_user_name;
	}
	public void setWrite_back_user_name(String write_back_user_name) {
		this.write_back_user_name = write_back_user_name;
	}
	public Integer getReview_id() {
		return review_id;
	}
	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}
	@Override
	public String toString() {
		return "WriteBack [id=" + id + ", station_id=" + station_id + ", review_user_name=" + review_user_name
				+ ", content=" + content + ", time=" + time + ", write_back_user_name=" + write_back_user_name
				+ ", review_id=" + review_id + "]";
	}
	
}
