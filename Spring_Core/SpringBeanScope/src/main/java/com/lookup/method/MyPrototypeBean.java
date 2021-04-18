package com.lookup.method;

import java.time.LocalDateTime;

public class MyPrototypeBean {
	private String dateTimeString = LocalDateTime.now().toString();

	public MyPrototypeBean() {
		System.out.println("Prototype instance created");
	}

	public String getDateTime() {
		return dateTimeString;
	}

}
