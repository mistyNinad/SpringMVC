package com.journaldev.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class MyInterceptor extends HandlerInterceptorAdapter{
	
	static{
		
		System.out.println(" Interceptor static block ..");
	}
	
	
	public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object Handler) {

		System.out.println("Inside the prehandle method. before executing handler method in controller.. ");
		return true;
		
	}
	
	
	public void postHandle(HttpServletRequest req,HttpServletResponse res,Object Handler , ModelAndView mav) 
	{
		System.out.println("Now Request is in Post handle method and View is yet to rendered");
	}
	
	
	
	
	public void afterCompletion(HttpServletRequest req,HttpServletRequest res,Object Handler, Exception ex) 
	{
		
		System.out.println("Inside After Completion method..Your View is rendered and your response has been given..");
	}



}
