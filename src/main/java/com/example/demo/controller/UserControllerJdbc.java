package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserJdbc;
import com.example.demo.repository.UserRepositoryJdbc;

@RestController
@RequestMapping("/api")
public class UserControllerJdbc {

	@Autowired
	UserRepositoryJdbc userRepositoryJdbc;
	
//	@GetMapping("/")
//	public ResponseEntity<String> index(){
//		return new  ResponseEntity<>("Index", HttpStatus.OK);
//	}
//	
	@GetMapping("/users2")
	public ResponseEntity<List<UserJdbc>> getAllUsers(@RequestParam(required = false) String username){
		try {
			List<UserJdbc> usersJdbcs = new ArrayList<>();
			if(username==null)
				userRepositoryJdbc.findAll().forEach(usersJdbcs::add);
			else
				userRepositoryJdbc.findByUsername(username);
			if(usersJdbcs.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(usersJdbcs, HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users2/{username}")
	public ResponseEntity<UserJdbc> getUserbyUsername(@PathParam("username") String username){
		UserJdbc userJdbc = userRepositoryJdbc.findByUsername(username);
		if (userJdbc!=null)
			return new ResponseEntity<>(userJdbc, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping("/users2")
	public ResponseEntity<String> insertUsers(@RequestBody UserJdbc userJdbc){
		try {
			int cnt = userRepositoryJdbc.insert(userJdbc);
			return new ResponseEntity<>(String.valueOf(cnt),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/users2/{userId}")
	public ResponseEntity<String> updateUsers(@PathVariable("userId") String userId,@RequestBody UserJdbc userJdbc){
		UserJdbc _userJdbc = userRepositoryJdbc.findByUsername(userId);
		if (_userJdbc !=null) {
			_userJdbc.setUserName(userJdbc.getUserName());
			_userJdbc.setDeptName(userJdbc.getDeptName());
			int cnt = userRepositoryJdbc.update(_userJdbc);
			return new ResponseEntity<>("Updated "+cnt,HttpStatus.OK);
		}else
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
