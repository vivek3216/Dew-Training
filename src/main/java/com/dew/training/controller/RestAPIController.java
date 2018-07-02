package com.dew.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
import com.dew.training.enums.FileType;
import com.dew.training.service.UserService;

@RestController
public class RestAPIController {


		@Autowired
		private UserService userService;
		
	//	@Autowired
	//  private CustomAuthenticationProvider customAuthenticationProvider;
		
		@ResponseBody
		@RequestMapping(value = "/userProfile",method=RequestMethod.POST,produces = "application/json")
		public User registeruser(@RequestBody User user) throws Exception {
			System.out.println("Update User : "+user.getEmail());
			User userDB=userService.addUser(user);
			return userDB;
			
		}
		
		@ResponseBody
		@RequestMapping(value = "/forgotPassword",produces="application/json")
		public void forgotPassword(@RequestParam String email) throws Exception {
			System.out.println("Your Password :");
			userService.sendForgotPassword(email);
		}
		
		@ResponseBody
		@RequestMapping(value = "/updateUserInfo",method=RequestMethod.POST,produces="application/json")
		public String updateUserInformation(@RequestBody UserInfo userInfo,HttpServletRequest httpServletRequest) {
			//update call
			int userId=0;
			if(httpServletRequest.getSession().getAttribute("DewUser")!=null){
				userId= (Integer) httpServletRequest.getSession().getAttribute("DewUser");
			}
			userInfo.setUser_id(userId);
			String status="success";
			try {
				userService.updateuserProfile(userInfo);
			} catch (Exception e) {
				status="failed";
				e.printStackTrace();
				// TODO: handle exception
				
			}
			
			return status;
		}
		
		@ResponseBody
		@RequestMapping(value = "/updateJobInfo",method=RequestMethod.POST,produces="application/json")
		public String updateJobInformation(@RequestBody JobInfo jobInfo,HttpServletRequest httpServletRequest) {
			int userId=0;
			if(httpServletRequest.getSession().getAttribute("DewUser")!=null){
				userId= (Integer) httpServletRequest.getSession().getAttribute("DewUser");
			}
			jobInfo.setUser_id(userId);
			String status="success";
			
			try {
				userService.updatejobProfile(jobInfo);
			} catch (Exception e) {
				status="failed";
				e.printStackTrace();
				// TODO: handle exception
				
			}
			
			return status;
		}
		
		
		@ResponseBody
		@RequestMapping(value = "/user/upload/",method = RequestMethod.POST,produces="application/json")
		public String uploadImage(@RequestParam MultipartFile file,@RequestParam FileType fileType,@RequestParam int userId){
			String status=null;
			try {
				status="success";
				userService.uploadFile(file,fileType,userId);
			} catch (Exception e) {
				e.printStackTrace();
				status="failure";
			}
			return status;
		}

}

