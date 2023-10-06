package com.litap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.litap.entity.User;


//database logic
@Repository
public class LoginDAO {

	@Autowired
	SessionFactory factory;
	
	public User getUser(String username) {
		
		Session session = factory.openSession();
		User userFromDb =  session.get(User.class, username);
		return userFromDb;		
	}
	
	
}
