package com.starv.firstspringboot.bean;

public class Result {

	private String uname;
	private Boolean success;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(String uname, Boolean success) {
		super();
		this.uname = uname;
		this.success = success;
	}
	
	
}
