package com.journaldev.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
 
	static {
		System.out.println(" Aspect class loaded . .");
	}
	
	
	@Before("execution (** com.journaldev.spring.model.Person.myAspectForPerson(..))")
	public void myAspect2(){	
		
		
		
		System.out.println(" ************ applying before advice.. 2 ************** ");
		 
	}
	
	
	@Around("execution (** com.journaldev.spring.model.Person.myAspectForPerson(..))")
	public void myAround ( ProceedingJoinPoint pjp  ) throws Throwable{		
		
		System.out.println(" ************ applying around advice.. of myAspectForPerson ************** ");
		
		pjp.proceed(); //calling advised method
		
		System.out.println("after method execution");
	
	}
	
	
	/*@Pointcut ("execution (** com.journaldev.spring.model.Person.getName(..))")
	public void validateName(){
		
	}
	
*/	/*@Before("execution (** com.journaldev.spring.PersonController.listPersons(..))")
	public void myAspect(){		
		System.out.println(" ************ hi inside aspect.. ************** ");
		
	}
	
	@Before("execution (* com.journaldev.spring.PersonController.m1(..))")
	public void m1Aspect(){		
		System.out.println(" ************ hi inside aspect. of M1 ************** ");
}
	
	
	@Before("execution (** com.journaldev.spring.model.Person.getName(..))")
	public void myAspect2(){		
		System.out.println(" ************ hi inside aspect.. of getname************** ");
		 
	}*/

	
	/*//@Before("validateName()")
	@Before("execution (** com.journaldev.spring.model.Person.myAspectForPerson(..))")
	public void myAspect3(){		
		System.out.println(" ************ applying before advice.. of myAspectForPerson ************** ");
		 
	}*/
	
	


	
	
}
