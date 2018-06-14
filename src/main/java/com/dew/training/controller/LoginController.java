package com.dew.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dew.training.auth.CustomAuthenticationProvider;
import com.dew.training.dto.LoginStatus;
import com.dew.training.dto.User;
import com.dew.training.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@ResponseBody
	@RequestMapping(value = "/register",method=RequestMethod.POST,produces = "application/json")
	public User registeruser(@RequestBody User user) throws Exception {
		System.out.println("Register User : "+user.getEmail());
		User userDB=userService.addUser(user);
		return userDB;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/login",produces="application/json",method=RequestMethod.POST)
	public LoginStatus doLogin(@RequestBody User user,HttpServletRequest request) {
		
		LoginStatus status=null;
		try {
			UsernamePasswordAuthenticationToken authenticationToken=null;
			authenticationToken = new UsernamePasswordAuthenticationToken(user, user.getPassword());
			Authentication authentication=null;
			authentication=customAuthenticationProvider.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			User signedInUser = userService.getUserByEmail(user.getEmail());
			request.setAttribute("dewUser", signedInUser.getUserId());
			status = new LoginStatus(authentication.isAuthenticated(),signedInUser.getFirstName(),signedInUser.getLastName(),signedInUser.getEmail(),signedInUser.getUserId());
			status.setStatus("success");
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			status.setStatus("failure");
			e.printStackTrace();
		}
		return status;
	}
	
}
