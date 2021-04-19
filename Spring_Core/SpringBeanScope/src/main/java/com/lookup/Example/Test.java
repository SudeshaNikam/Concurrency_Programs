package com.lookup.Example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MySingletonBean bean = context.getBean(MySingletonBean.class);
		bean.message();
		Thread.sleep(1000);
		
		bean = context.getBean(MySingletonBean.class);
		bean.message();
	}
}
