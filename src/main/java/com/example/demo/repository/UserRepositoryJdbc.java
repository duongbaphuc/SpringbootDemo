package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.UserJdbc;

public interface UserRepositoryJdbc {
	
	List<UserJdbc> findAll();	
	UserJdbc findByUsername(String userName);
	UserJdbc findByUserId(String userId);	
	int update(UserJdbc userJdbc);
	int insert(UserJdbc userJdbc);
	int deletebyUserId(String userId);
	int deleteAll();

}
