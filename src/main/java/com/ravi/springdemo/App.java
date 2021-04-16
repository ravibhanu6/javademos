package com.ravi.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context= new ClassPathXmlApplicationContext("SpringConfig.xml");
       
       Restaurant obj=(Restaurant) context.getBean("restaurantBean");
       obj.displayWaitersNames();
       
    }
}
