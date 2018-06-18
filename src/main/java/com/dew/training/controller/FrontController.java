package com.dew.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/myProfile")
	public ModelAndView openmyProfilePage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("userProfile");
		return modelAndView;
	}
}
