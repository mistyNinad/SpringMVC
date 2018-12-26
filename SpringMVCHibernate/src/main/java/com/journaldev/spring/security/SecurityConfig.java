package com.journaldev.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.stereotype.Component;


@Configuration
@EnableWebSecurity
@ComponentScan("com.journaldev")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
   @Bean(name="ninad")
    public Object beancreate(){
   	 System.out.println("creating bean in security...");
   	 return new String("dasda");
    }
	
	static{
		System.out.println(" Security Config loaded.......");
		
	}
	
	//STORE
	
	@Autowired
	public void configureGlobalSecurity ( AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}admin")
		.roles("ADMIN")
		.and().
		withUser("tanmayee")
		.password("{noop}123").roles("USER");
		
	
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http ) throws Exception{
		
		/*http.authorizeRequests().antMatchers("/").authenticated().anyRequest().authenticated()
		.and().formLogin();*/
		
		http.authorizeRequests().antMatchers("/").authenticated()
		.antMatchers("/persons").hasRole("ADMIN")
		.and()
		.rememberMe().and()
		.formLogin()
		.and()
		.httpBasic();
		
	
		
		http.requiresChannel().antMatchers("/").requiresSecure(); //https
		
		/*http.antMatcher("/")
    	.authorizeRequests()  
    	.anyRequest()
    	.authenticated()  
    	.and()  
    	.formLogin()
    	.and() 
    	.httpBasic();*/
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
   
	}	
}