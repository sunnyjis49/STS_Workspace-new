package com.sun.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sun/springcore/collections/collectionconfig.xml");
		Emp emp1 = (Emp) context.getBean("emp1");
		System.out.println("emp1: "+emp1);
		System.out.println("By default list type: "+emp1.getPhones().getClass().getName());
	}

}
