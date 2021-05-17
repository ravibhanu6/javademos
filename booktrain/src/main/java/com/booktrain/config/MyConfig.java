package com.booktrain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.booktrain.interceptor.AuthenticationInterceptor;


@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
	
	
	  @Autowired 
	  private AuthenticationInterceptor authenticationInterceptor;
	
	  @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**").excludePathPatterns("/user/register","/hello","/load_data");
	    }
}
