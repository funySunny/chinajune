package com.ChargePoint.bean;

public class PCUser {
	private int id;
	private String user_name;	
	private String password;
	private String email_code;
	private String email;
	private String reg_time;
	private String tel;
	private String access;
	private String reg_no;
	private String employee_no;
	private String question;
	private String answer;
	private String head_portrait;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail_code() {
		return email_code;
	}

	public void setEmail_code(String email_code) {
		this.email_code = email_code;
	}

	public String getReg_time() {
		if(null != reg_time && -1 != reg_time.lastIndexOf("."))
		{
			return reg_time.substring(0,reg_time.lastIndexOf("."));
		}else{
			return reg_time;
		}
	}

	public void setReg_time(String reg_time) {
		this.reg_time = reg_time;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getHead_portrait() {
		return head_portrait;
	}

	public void setHead_portrait(String head_portrait) {
		this.head_portrait = head_portrait;
	}

	@Override
	public String toString() {
		return "PCUser [id=" + id + ", user_name=" + user_name + ", password=" + password + ", email_code=" + email_code
				+ ", email=" + email + ", reg_time=" + reg_time + ", tel=" + tel + ", access=" + access + ", reg_no="
				+ reg_no + ", employee_no=" + employee_no + ", question=" + question + ", answer=" + answer
				+ ", head_portrait=" + head_portrait + "]";
	}

}
