package com.dew.training.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
		int userId=0;
		if(request.getSession().getAttribute("DewUser")!=null){
			userId= (Integer) request.getSession().getAttribute("DewUser");
			User user = userService.getUserByUserId(userId);
			modelAndView.addObject("userObj", user);
		}
		
		return modelAndView;
		
	}
	
	@RequestMapping("/user/dashboard")
	public ModelAndView showdashBoard(HttpServletRequest httpServletRequest) {
		int userId=0;
		if(httpServletRequest.getSession().getAttribute("DewUser")!=null){
			userId= (Integer) httpServletRequest.getSession().getAttribute("DewUser");
		}
		
		ModelAndView modelAndView = new ModelAndView("dashboard");
		if(userId>0){
			User user = userService.getUserByUserId(userId);
			modelAndView.addObject("userObj", user);
		}
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
		int userId=0;
		if(request.getSession().getAttribute("DewUser")!=null){
			userId= (Integer) request.getSession().getAttribute("DewUser");
		}
		
		if(userId>0){
			User user = userService.getUserByUserId(userId);
			modelAndView.addObject("userObj", user);
			UserInfo userInfo= userService.getUserInfo(userId);
			if(userInfo==null){
				modelAndView.setView(new RedirectView("/user/addupdateProfile", true));	
				return modelAndView;
				
			}
			JobInfo jobInfo=userService.getJobInfo(userId);
			modelAndView.addObject("userInfo", userInfo);
			modelAndView.addObject("jobInfo", jobInfo);
			
		}
		return modelAndView;
	}
	
	@RequestMapping("/user/addupdateProfile")
	public ModelAndView openUpdatePage(HttpServletRequest request){
		int userId=0;
		if(request.getSession().getAttribute("DewUser")!=null){
			userId= (Integer) request.getSession().getAttribute("DewUser");
		}
		ModelAndView modelAndView = new ModelAndView("updatePage");
		if(userId>0){
			User user = userService.getUserByUserId(userId);
			modelAndView.addObject("userObj", user);
		}
		UserInfo userInfo= userService.getUserInfo(userId);
		
		modelAndView.addObject("userInfo", userInfo);
		
		return modelAndView;
	}
	
	@RequestMapping("/user/addjobProfile")
	public ModelAndView openJobProfilePage(HttpServletRequest request){
		int userId=0;
		if(request.getSession().getAttribute("DewUser")!=null){
			userId= (Integer) request.getSession().getAttribute("DewUser");
		}
		JobInfo jobInfo=userService.getJobInfo(userId);
		ModelAndView modelAndView = new ModelAndView("jobProfile");
		modelAndView.addObject("jobInfo", jobInfo);
		return modelAndView;
	}
}
