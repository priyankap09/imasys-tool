package com.litap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litap.dao.UserDAO;
import com.litap.entity.User;
import com.litap.exceptions.UserException;

@Service
public class UserService {
	
	
	@Autowired
	UserDAO userDAO;
	
	
	public void saveUser(boolean saveWithDetails) {
		
	}
	
	public List<User> getAllUsers() {
		Optional<List<User>> userList = userDAO.getUserList();
		
		if(userList.isPresent())
		return userList.get();
		else
			throw new UserException("USER LIST IS EMPTY");
	}

}
