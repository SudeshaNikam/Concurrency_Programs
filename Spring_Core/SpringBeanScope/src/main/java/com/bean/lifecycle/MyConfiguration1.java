package com.bean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration1 {

	@Bean
	@Scope(value = "singleton")
	public UserData user() {
		return new UserData();
	}

}
