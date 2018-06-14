package com.dew.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dew.training.dao.UserDao;
import com.dew.training.dto.User;
import com.dew.training.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDAO;
	
	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User user1=userDAO.addUser(user);
		
		
		//mail
		return user1;
	}

	@Override
	public User signIn(User user) {
		return userDAO.signIn(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

}
