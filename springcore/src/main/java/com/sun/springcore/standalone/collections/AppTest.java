package com.sun.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sun/springcore/standalone/collections/alonecollectionconfig.xml");
		Person person1 = context.getBean("person1", Person.class);
		System.out.println("person1: "+person1);
		System.out.println("By default list type: "+person1.getFriends().getClass().getName());
		System.out.println("By default list type: "+person1.getFeestructure().getClass().getName());
	}

}
