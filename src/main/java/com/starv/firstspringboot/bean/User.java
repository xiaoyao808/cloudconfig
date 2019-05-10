package com.starv.firstspringboot.bean;

public class User {

	
	private Integer id;
	private String uname;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", uname='" + uname + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
