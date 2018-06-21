package com.dew.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dew.training.auth.CustomAuthenticationProvider;
import com.dew.training.dto.LoginStatus;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
import com.dew.training.service.UserService;
import com.google.api.client.util.Value;

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
		public String forgotPassword(@RequestParam String email) {
			//
		return null;
		}
		
		@ResponseBody
		@RequestMapping(value = "/updateUserInfo",method=RequestMethod.POST,produces="application/json")
		public String updateUserInformation(@RequestBody UserInfo userInfo,HttpServletRequest httpServletRequest) {
			//update call
			String status="success";
			try {
				userService.updateuserProfile(userInfo);
			} catch (Exception e) {
				status="faileu";
				// TODO: handle exception
				
			}
			
			return status;
		}

}

