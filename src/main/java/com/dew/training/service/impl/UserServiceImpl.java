package com.dew.training.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dew.training.dao.UserDao;
import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
import com.dew.training.enums.FileType;
import com.dew.training.enums.MailMessageType;
import com.dew.training.service.EmailService;
import com.dew.training.service.UserService;
import com.dew.training.util.ApplicationProperties;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDAO;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User user1=userDAO.addUser(user);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("firstName", user.getFirstName());
		params.put("email", user.getEmail());
		params.put("lastName", user.getLastName());
		params.put("domainName",ApplicationProperties.getProperty("domainName"));
		emailService.sendMail(MailMessageType.WELCOME_MAIL,params);
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

	@Override
	public void uploadFile(MultipartFile file, FileType fileType,int userId) {
		String ext=fileType.toString().equals(FileType.RESUME) ? FilenameUtils.getExtension(file.getOriginalFilename()):".jpg";
		String path=ApplicationProperties.getProperty("fileLocation")+ userId + "_" +fileType+"."+ext+"";
		if(!StringUtils.isEmpty(file.getOriginalFilename())){
			try {
				File existingFile = new File(path);
				if(existingFile.exists())
					existingFile.delete();
				file.transferTo(new File(path));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}