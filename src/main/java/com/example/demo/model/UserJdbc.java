package com.example.demo.model;

public class UserJdbc {
	
	String userId;
	String userName;
	String deptName;
	
	public UserJdbc(){
		
	}

	public UserJdbc(String userId, String userName, String deptName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.deptName = deptName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	

}
