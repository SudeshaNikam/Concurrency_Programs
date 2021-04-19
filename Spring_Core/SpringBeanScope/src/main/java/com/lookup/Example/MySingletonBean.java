package com.lookup.Example;

import javax.inject.Provider;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MySingletonBean {

	@Autowired
	private MyPrototypeBean prototypeBean;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Provider<MyPrototypeBean> beanProvider;

	@Autowired
	private ObjectFactory<MyPrototypeBean> ojectFactory;

	// prototype bean inside singleton bean

//	public void message() {
//		System.out.println(prototypeBean.getDateTime());
//	}

	// Using Lookup

	public void message() {
		MyPrototypeBean bean = getPrototypeBean();
		System.out.println(bean.getDateTime());
	}

	@Lookup
	public MyPrototypeBean getPrototypeBean() {
		return null;
	}

	// javax inject provider
//
//	public void message() {
//		MyPrototypeBean bean = beanProvider.get();
//		System.out.println("the time is " + bean.getDateTime());
//	}
//
//	// object factory
//
//	public void message() {
//		MyPrototypeBean bean = ojectFactory.getObject();
//		System.out.println("the time is " + bean.getDateTime());
//	}
//
//	// Application Context
//	public void message() {
//		MyPrototypeBean bean = applicationContext.getBean(MyPrototypeBean.class);
//		System.out.println("the time is " + bean.getDateTime());
//	}
}