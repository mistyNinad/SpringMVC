package com.journaldev.spring.model;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String username;
	private String password;
	 
	
	
	private String country;

	
	public Person(String string) {
	this.name=string;
	}
	
	

	public Person() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void myAspectForPerson(){
		System.out.println("inside advised method");
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country;
	}

}
