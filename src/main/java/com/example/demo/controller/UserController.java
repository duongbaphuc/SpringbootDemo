package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@GetMapping("/")
	public ResponseEntity<String> index(){
		return new  ResponseEntity<>("Index", HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String username){
		try {
			List<User> users = new ArrayList<>();
			if(username==null)
				userRepository.findAll().forEach(users::add);
			else
				userRepository.findByUsername(username).forEach(users::add);
			if(users.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(users, HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
