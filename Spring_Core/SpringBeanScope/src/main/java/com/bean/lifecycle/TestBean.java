package com.bean.lifecycle;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
	public static void main(String[] args) {

		// Using init-method and destroy-method

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springBean.xml");
		UserData cust = (UserData) context.getBean("userData");
		System.out.println(cust);
		context.close();

		// Using @predestroy and @PostConstruct

		AnnotationConfigApplicationContext ctx1 = new AnnotationConfigApplicationContext();
		ctx1.register(MyConfiguration1.class);
		ctx1.refresh();
		UserData userdata = ctx1.getBean(UserData.class);
		System.out.println(userdata.hashCode());

		UserData userdata1 = ctx1.getBean(UserData.class);
		System.out.println(userdata1.hashCode());
		ctx1.close();
	}
}