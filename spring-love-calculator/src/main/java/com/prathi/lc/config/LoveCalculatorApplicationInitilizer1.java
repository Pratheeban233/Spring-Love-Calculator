package com.prathi.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*
 *  @ Approach 1
 *  Here will create the application setup by XML based configuration (appconfig.xml) 
 *  and Java based configuration (appconfig.class)
 *  WebApplicationInitializer Interface is the super power to provide the base configuration 
 * 
 * 	WebServer will detect the application using 
 * 	1.Web.xml (legacy). Web.xml having the appconfig.xml to load the application
 * 	2.Here webserver dectect the application by using the interface implements WebApplicationInitializer (importatnt)
 */

//commented WebApplicationInitializer for to activate approach 2
public class LoveCalculatorApplicationInitilizer1 // implements WebApplicationInitializer
{

	public void onStartup(ServletContext servletContext) throws ServletException {

		// XML based configuration
		/*
		 * XmlWebApplicationContext webApplicationContext = new
		 * XmlWebApplicationContext();
		 * webApplicationContext.setConfigLocation("classpath:application-config.xml");
		 */

		// Java based application configuration
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		// Create a dispatcher object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

		// Register the dispatcherServlet with Servlet context
		ServletRegistration.Dynamic myCustomDispatcherServletConfig = servletContext.addServlet("myDispacherServlet",
				dispatcherServlet);
		myCustomDispatcherServletConfig.setLoadOnStartup(1);
		myCustomDispatcherServletConfig.addMapping("/mywebsite.com/*");
	}

}
