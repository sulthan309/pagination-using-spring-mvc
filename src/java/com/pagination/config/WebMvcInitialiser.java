package com.pagination.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebMvcInitialiser implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic registration=servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		registration.addMapping("/");
		registration.setLoadOnStartup(1);
		
	}

}
