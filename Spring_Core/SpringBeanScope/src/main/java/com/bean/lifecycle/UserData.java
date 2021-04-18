package com.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserData {
	String name;
	String city;

	public UserData() {
		System.out.println("Bean instance created");
	}

	public UserData(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void initMethod() throws Exception {
		System.out.println("Init method  " + name);
	}

	public void destroyMethod() throws Exception {
		System.out.println(" destroy method");
	}

	@PostConstruct
	public void init() throws Exception {
		System.out.println("Bean has been instantiated ");
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Conatiner has been closed");
	}

	@Override
	public String toString() {
		return "UserData [name=" + name + ", city=" + city + "]";
	}

}
