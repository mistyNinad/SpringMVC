package com.journaldev.spring;

import java.io.IOException;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;

@ControllerAdvice
@Component
@ComponentScan
public class AdviceController {

/*	fhfhghf
	@Autowired
	private PersonService personService;
	
	@ExceptionHandler(MyException.class)
	public ModelAndView handlingCustomMethod(Model model)
	{
		System.out.println("Inside Custom Handling Method");
		
		ModelAndView mav = new ModelAndView("person");
		mav.addObject("person",new Person());
		mav.addObject("listPersons",this.personService.listPersons());
		return mav;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handlingSystemMethod(Model model,RuntimeException ex)
	{
		System.out.println("Inside Custom Handling Method");
		model.addAttribute("person",new Person());
		System.out.println("Redirecting your request");
		return "redirect:/persons";
	}
	
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST ,reason="IO Exception")
	@ExceptionHandler(IOException.class)
	public String handlingSystemMEthod(IOException ex,Model model)
	{
		System.out.println("Inside System Exception handling method..");
		model.addAttribute("persons",new Person());
		return "person";
	}*/
	
	
	
}
