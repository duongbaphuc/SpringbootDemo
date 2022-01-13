package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="TB_A10_USR_INF")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_NM")
	private String username;

	
	public User() {}
	

	public User(String userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	
	
}
