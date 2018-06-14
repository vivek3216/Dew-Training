package com.dew.training.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

private static final Logger logger = Logger.getLogger(BaseController.class);
	
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	    logger.error("Request: " + req.getRequestURL() + " raised " + exception);
	    ModelAndView mav = new ModelAndView();
	    StringWriter s = new StringWriter();
	    PrintWriter ps = new PrintWriter(s);
	    exception.printStackTrace(ps);
	    mav.addObject("exception", s.toString());
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	  }
}
