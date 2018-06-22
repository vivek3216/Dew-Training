package com.dew.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.training.dao.UserDao;
import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
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
	
	@Override
	public UserInfo updateuserProfile(UserInfo userInfo) throws Exception{
		// TODO Auto-generated method stub
		if(userInfo.getUser_profile_id()>0)
			userDAO.updateProfile(userInfo);
		else
			userInfo =userDAO.addUserProfile(userInfo);
			return userInfo;		
	}
	
	@Override
	public JobInfo updatejobProfile(JobInfo jobInfo) throws Exception {
		// TODO Auto-generated method stub
		if(jobInfo.getJob_profile_id()>0)
			userDAO.updatejob(jobInfo);
		else
			jobInfo =userDAO.addJobProfile(jobInfo);
			return jobInfo;
	}

	@Override
	public User getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getUserInfo(int userId) {
		// TODO Auto-generated method stub
		return userDAO.getUserInfo(userId);
	}

	
}