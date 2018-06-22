package com.dew.training.dao;

import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;

public interface UserDao {

	public User addUser(User user) throws Exception;

	public User signIn(User user);

	public User getUserByEmail(String email);

	public void updateProfile(UserInfo userInfo) throws Exception;

	public void updatejob(JobInfo jobInfo) throws Exception;

	public UserInfo addUserProfile(UserInfo userInfo);
	
	public JobInfo addJobProfile(JobInfo jobInfo);

	public UserInfo getUserInfo(int userId);
	
	public void getPassword(String Password);
}
