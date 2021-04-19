package com.lookup.Example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackageClasses = MySingletonBean.class)
public class AppConfig {

	@Bean
	@Scope(value = "prototype")
	public MyPrototypeBean prototypeBean() {
		return new MyPrototypeBean();
	}

}