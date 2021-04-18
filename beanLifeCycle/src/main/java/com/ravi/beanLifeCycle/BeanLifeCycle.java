package com.ravi.beanLifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class BeanLifeCycle implements InitializingBean, DisposableBean {

	String message;

	public String getMessage() {
		return message;
	}

	@Value("Test for Bean")
	public void setMessage(String message) {
		this.message = message;
	}
	public void initmethod() throws Exception {
		System.out.println("Init method after properties are set : " + message);
	}

	@PostConstruct
	public void customInit() {
		System.out.println("Method customInit() invoked...");
	}

	public void destroymethod() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");
	}

	@PreDestroy
	public void customDestroy() {
		System.out.println("Method customDestroy() invoked...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertiesSet method of lifecycle bean is called");

	}

	public void destroy() throws Exception {
		System.out.println("Destroy method of lifecycle is called");

	}

}
