package com.prathi.lc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.prathi.lc.formatters.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.prathi.lc.contollers")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {

	// Set up view resolver
	@Bean
	public InternalResourceViewResolver ViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		System.out.println("inside the addFormatters method in LoveCalculatorAppConfig");
		//pass the instance of the formatter
		registry.addFormatter(new PhoneNumberFormatter());
	}
	
}
