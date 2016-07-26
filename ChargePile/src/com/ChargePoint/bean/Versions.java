package com.ChargePoint.bean;

public class Versions {
	private Integer id;
	private String version_no;
	private double size;
	private String content;
	private String upload_time;
	private String upload_url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVersion_no() {
		return version_no;
	}
	public void setVersion_no(String version_no) {
		this.version_no = version_no;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public String getUpload_url() {
		return upload_url;
	}
	public void setUpload_url(String upload_url) {
		this.upload_url = upload_url;
	}
	@Override
	public String toString() {
		return "Versions [id=" + id + ", version_no=" + version_no + ", size=" + size + ", content=" + content
				+ ", upload_time=" + upload_time + ", upload_url=" + upload_url + "]";
	}
	
}
