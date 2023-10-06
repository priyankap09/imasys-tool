package com.litap.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.litap.entity.User;

@Repository
public class UserDAO {
	
	@Autowired
	SessionFactory factory;
	
	public void saveUser() {
		
	}
	
	public void saveUserDetails() {
		
	}
	
	public Optional<List<User>> getUserList(){
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		
		List<User> userList =  criteria.list();
		
		return Optional.ofNullable(userList);
	}

}
