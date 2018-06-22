package com.dew.training.service;

import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;

public interface UserService {

	public User addUser(User user) throws Exception;

	public User signIn(User user);

	public User getUserByEmail(String email);

	public UserInfo updateuserProfile(UserInfo userInfo) throws Exception;
	
	public JobInfo updatejobProfile(JobInfo jobInfo) throws Exception;

	public User getUserByUserId(int userId);

	public UserInfo getUserInfo(int userId);
}
