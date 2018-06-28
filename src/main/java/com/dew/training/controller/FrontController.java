package com.dew.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
import com.dew.training.service.UserService;

@Controller
public class FrontController extends BaseController{

	@Autowired private UserService userService;
	@RequestMapping("/")
	public ModelAndView showHomePage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("home1");
		return modelAndView;
		
	}
	
	@RequestMapping("/user/dashboard")
	public ModelAndView showdashBoard(HttpServletRequest httpServletRequest) {
		int userId = Integer.valueOf(httpServletRequest.getAttribute("dewUser").toString());
		if(userId == 0) {
			//invalid access page
		}
		
		//User user = userService.getUserByUserId(userId);
		ModelAndView modelAndView = new ModelAndView("dashboard");
		//modelAndView.addObject("userObj", user);
		return modelAndView;
	}

	@RequestMapping("/registerMe")
	public ModelAndView openRegisterPage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}
	
	@RequestMapping("/user/myProfile")
	public ModelAndView openmyProfilePage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("userProfile");
		/*int userId = Integer.valueOf((String) request.getAttribute("dewUser"));*/
		UserInfo userInfo= userService.getUserInfo(1);
		JobInfo jobInfo=userService.getJobInfo(1);
		modelAndView.addObject("userInfo", userInfo);
		modelAndView.addObject("jobInfo", jobInfo);
		return modelAndView;
	}
	
	@RequestMapping("/user/addupdateProfile")
	public ModelAndView openUpdatePage(HttpServletRequest request){
		UserInfo userInfo= userService.getUserInfo(1);
		ModelAndView modelAndView = new ModelAndView("updatePage");
		modelAndView.addObject("userInfo", userInfo);
		
		
		return modelAndView;
	}
	
	@RequestMapping("/user/addjobProfile")
	public ModelAndView openJobProfilePage(HttpServletRequest request){
		/*int userId=Integer.valueOf((String) request.getAttribute("dewUser"));
		User user = userService.getUserByUserId(userId);
		if(user==null) {
			
		}*/
		JobInfo jobInfo=userService.getJobInfo(1);
		ModelAndView modelAndView = new ModelAndView("jobProfile");
		modelAndView.addObject("jobInfo", jobInfo);

		
		
		return modelAndView;
	}
}
