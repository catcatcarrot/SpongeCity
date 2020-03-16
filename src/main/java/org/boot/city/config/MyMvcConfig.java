package org.boot.city.config;

import org.boot.city.converter.MyDateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new MyDateConverter());
	}

}
