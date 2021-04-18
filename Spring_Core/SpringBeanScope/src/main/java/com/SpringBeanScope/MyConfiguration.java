package com.SpringBeanScope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {

	@Bean
	@Scope(value = "singleton")
	public Address address() {
		return new Address();
	}
	
	/*
	 * @Bean
	 * 
	 * @Scope(value = "prototype") public Address address() { return new Address();
	 * }
	 */
}
