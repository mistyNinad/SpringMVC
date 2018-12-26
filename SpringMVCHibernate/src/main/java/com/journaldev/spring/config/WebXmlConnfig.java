package com.journaldev.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.journaldev.spring.security.MyWebMvcConfigurer;
//import com.journaldev.spring.security.MyWebMvcConfigurer;
import com.journaldev.spring.security.SecurityConfig;

public class WebXmlConnfig implements WebApplicationInitializer {

	
	
	public void onStartup(ServletContext container) {
    	
    	
    	System.out.println("in webxxml config new  ");
      // Create the 'root' Spring application context
      AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
      rootContext.register(DispatcherConfig.class);
      // Manage the lifecycle of the root application context
      // container.addListener(new ContextLoaderListener(rootContext));

    // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext =   new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(DispatcherConfig.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
    }



protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { DispatcherConfig.class ,MyWebMvcConfigurer.class /*SecurityConfig.class*/ };
}

protected String[] getServletMappings() {
    return new String[] { "/" };
}

protected Class<?>[] getRootConfigClasses() {
    return null;
}
   
	/*static{
		System.out.println("web . xml loaded");
	}
	
	protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { DispatcherConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
	
    public void onStartup(ServletContext container) {
    	
    	System.out.println("in webxxml config  ");
      // Create the 'root' Spring application context
     AnnotationConfigWebApplicationContext rootContext =  new AnnotationConfigWebApplicationContext();
      rootContext.register(DispatcherConfig.class);

      // Manage the lifecycle of the root application context
   //  container.addListener(new ContextLoaderListener(rootContext));

    // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(DispatcherConfig.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
    }*/
    
}