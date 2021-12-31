package com.sun.springcore.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.springcore.ref.Addition;

public class CiAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sun/springcore/constructorinjection/ciconfig.xml");
		Person person1 = (Person) context.getBean("person1");
		System.out.println("person1: "+person1);
		
		Addition add = (Addition) context.getBean("addition");
		add.doAddition();
		
	}

}
