package com.ChargePoint.bean;

public class AddHeart {

	private Integer id;
	private Integer station_id;
	private String review_user_name;
	private String add_heart_user_name;
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
	public String getAdd_heart_user_name() {
		return add_heart_user_name;
	}
	public void setAdd_heart_user_name(String add_heart_user_name) {
		this.add_heart_user_name = add_heart_user_name;
	}
	public Integer getReview_id() {
		return review_id;
	}
	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}
	@Override
	public String toString() {
		return "AddHeart [id=" + id + ", station_id=" + station_id + ", review_user_name=" + review_user_name
				+ ", add_heart_user_name=" + add_heart_user_name + ", review_id=" + review_id + "]";
	}

}
