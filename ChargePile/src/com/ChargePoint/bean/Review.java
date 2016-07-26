package com.ChargePoint.bean;

public class Review {

	private Integer id;
	private Integer station_id;
	private String review_user_name;
	private String content;
	private Integer score;
	private String time;
	private String head_portrait;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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
	public String getHead_portrait() {
		return head_portrait;
	}
	public void setHead_portrait(String head_portrait) {
		this.head_portrait = head_portrait;
	}
	public Integer getStation_id() {
		return station_id;
	}
	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", review_user_name=" + review_user_name
				+ ", content=" + content + ", score=" + score + ", time=" + time + ", head_portrait=" + head_portrait
				+ ", station_id=" + station_id + "]";
	}
	
}
