package com.ravi.beanLifeCycle;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
		BeanLifeCycle beanlifecycle = applicationContext.getBean("beanlifecycle", BeanLifeCycle.class);
		applicationContext.registerShutdownHook();

	}
}
