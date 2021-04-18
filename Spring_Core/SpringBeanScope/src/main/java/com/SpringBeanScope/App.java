package com.SpringBeanScope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MyConfiguration.class);
		ctx.refresh();

		Address mb1 = ctx.getBean(Address.class);
		System.out.println(mb1.hashCode());

		Address mb2 = ctx.getBean(Address.class);
		System.out.println(mb2.hashCode());

		ctx.close();
	}
}
