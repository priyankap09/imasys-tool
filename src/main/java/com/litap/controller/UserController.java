package com.litap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.litap.entity.User;
import com.litap.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService service;
	
	@RequestMapping("/save/user")
	public void saveUser() {
		
		service.saveUser(false);
		
	}
	
	
	@RequestMapping("/getallusers")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	
}
