package com.journaldev.spring;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Product;
import com.journaldev.spring.myconfig.Beans;
import com.journaldev.spring.service.PersonService;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	//Beans is a @configuration class , where we create beans
	@Autowired
	Beans bean;
	
	/*@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}*/
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ModelAndView listPersons(Model model , @AuthenticationPrincipal User user , Principal prin) throws CustomException {		
		System.out.println(" ***inside person*** "+user.getUsername() );
		
		/*if(true){
			throw new CustomException();
		}*/
		
		Collection<GrantedAuthority> l  =user.getAuthorities();		
		
        System.out.println("prin obj "+prin.getName());
        //AOP
		Person p =bean.getPersonBean();
		p.myAspectForPerson();
		
		System.out.println("after calling ASPECT..");
		
		model.addAttribute("personContainer", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		ModelAndView mav = new ModelAndView();
		mav.addObject(this.personService.listPersons());
		mav.setViewName("person");		
		
		
		
		return mav;
	}
	
	
	
	
/*	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView listProducts(Model model) {		
		System.out.println("inside list products...");		
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.personService.listPersons());
		ModelAndView mav = new ModelAndView();
		mav.addObject(this.personService.listPersons());
		mav.setViewName("person");		
		
		return mav;
	}
	*/
	
	@ExceptionHandler(CustomException.class)
	 public void MyExceptionHandler () {
		 System.out.println("in excpn handling method..");		 
		// throw new MyException("hcziuxhc");
		// return"redirect:/persons";
	 }
	

	
	//For add and update person both
	@PostMapping
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("personContainer") Person p){
		
		System.out.println("inside add person...");
		System.out.println("name......"+p.getName());
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    
    
    
    
	
}
