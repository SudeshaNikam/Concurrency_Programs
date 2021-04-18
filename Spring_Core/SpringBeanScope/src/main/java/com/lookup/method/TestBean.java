package com.lookup.method;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBean {
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Prototype Beans into a Singleton Instance in Spring

		MyPrototypeBean firstPrototype = context.getBean(MySingletonBean.class).getPrototypeBean();
		System.out.println("" + firstPrototype.hashCode());
		
		// get singleton bean instance one more time
		MyPrototypeBean secondPrototype = context.getBean(MySingletonBean.class).getPrototypeBean();
		System.out.println("" + secondPrototype.hashCode());
	}
}
