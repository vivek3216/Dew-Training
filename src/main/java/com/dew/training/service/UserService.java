package com.dew.training.service;

import org.springframework.web.multipart.MultipartFile;

import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
import com.dew.training.enums.FileType;

public interface UserService {

	public User addUser(User user) throws Exception;

	public User signIn(User user);

	public User getUserByEmail(String email);

	public UserInfo updateuserProfile(UserInfo userInfo) throws Exception;
	
	public JobInfo updatejobProfile(JobInfo jobInfo) throws Exception;

	public User getUserByUserId(int userId);

	public UserInfo getUserInfo(int userId);

	public void uploadFile(MultipartFile file, FileType fileType, int userId);

	public JobInfo getJobInfo(int userId);

	public void sendForgotPassword(String email);
}
