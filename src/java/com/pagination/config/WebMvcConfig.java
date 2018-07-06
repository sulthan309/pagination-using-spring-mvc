package com.pagination.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@Import({DaoConfig.class})
@EnableWebMvc
@ComponentScan("com.pagination")
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();

		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);

		return resolver;
	}
	
	@Bean
	public PropertyPlaceholderConfigurer getPlaceHolderConfigurer() {
		PropertyPlaceholderConfigurer configurer=new PropertyPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("app.properties"));
		configurer.setIgnoreUnresolvablePlaceholders(true);
		return configurer;
	}
	
}
