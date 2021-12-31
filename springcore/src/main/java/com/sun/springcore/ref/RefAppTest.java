package com.sun.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sun/springcore/ref/refconfig.xml");
		A aref = (A) context.getBean("aref");
		System.out.println("aref: "+aref);
	}

}
