package com.lookup.method;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope(value = "prototype")
	public MyPrototypeBean prototypeBean() {
		return new MyPrototypeBean();
	}

	@Bean
	public MySingletonBean singletonBean() {
		return new MySingletonBean();
	}
	
	
}
