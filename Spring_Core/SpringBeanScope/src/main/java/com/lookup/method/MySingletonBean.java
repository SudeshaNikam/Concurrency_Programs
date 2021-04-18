package com.lookup.method;

import java.time.LocalTime;

import javax.inject.Provider;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;

public class MySingletonBean {

	@Autowired
	private MyPrototypeBean prototypeBean;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Provider<MyPrototypeBean> myPrototypeBeanProvider;

	@Autowired
	private ObjectFactory<MyPrototypeBean> prototypeBeanObjectFactory;

	public MySingletonBean() {
		System.out.println("Singleton instance created");
	}

	/*
	 * public MyPrototypeBean getPrototypeBean() { System.out.println("data Time - "
	 * + String.valueOf(LocalTime.now())); return prototypeBean; }
	 */

	// javax.inject API

	public MyPrototypeBean getPrototypeBean() {
		System.out.println("data Time - " + String.valueOf(LocalTime.now()));
		return myPrototypeBeanProvider.get();
	}

	// ObjectFactory Interface

	/*
	 * public MyPrototypeBean getPrototypeBean() { System.out.println("data Time - "
	 * + String.valueOf(LocalTime.now())); return
	 * prototypeBeanObjectFactory.getObject(); }
	 */

	// Using applicationContext

	/*
	 * public MyPrototypeBean getPrototypeBean() { System.out.println("data Time - "
	 * + String.valueOf(LocalTime.now())); return
	 * applicationContext.getBean(prototypeBean.getClass()); }
	 */
}
