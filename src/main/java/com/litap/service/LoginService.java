package com.litap.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litap.dao.LoginDAO;
import com.litap.entity.User;

@Service
public class LoginService {
	
	
	@Autowired 
	LoginDAO dao;
	
	public String validateService(String usernamefrombrowser, String passwordfrombrowser) {
		
		User userFromDb = dao.getUser(usernamefrombrowser);
		
		if(userFromDb == null)
			return "INVALID";
		if(userFromDb.getPassword().equals(passwordfrombrowser))		
			return userFromDb.getRole();
		else
			return "INVALID";
	}
	
	

}
