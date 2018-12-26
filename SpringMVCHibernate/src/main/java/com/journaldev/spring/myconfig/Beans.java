package com.journaldev.spring.myconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.journaldev.spring.aop.LoggerAspect;
import com.journaldev.spring.model.Person;

@EnableAspectJAutoProxy
//@Configuration
@Component
public class Beans {

	@Bean
	public Person getPersonBean(){	
		System.out.println("creating bean..");
		return new Person("Ninad");		
	}
	

	@Lazy
	@Bean
	public LoggerAspect getLoggerAspect(){
		return new LoggerAspect();
	}
	
	
}
