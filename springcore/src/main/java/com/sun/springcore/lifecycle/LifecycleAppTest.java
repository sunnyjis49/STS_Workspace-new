package com.sun.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/sun/springcore/lifecycle/lifecycleconfig.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/sun/springcore/lifecycle/lifecycleconfig.xml");
		//Samosa samosa1 = (Samosa) context.getBean("samosa1");
		
		//System.out.println(samosa1);
		//registering shutdown hook will call destroy method
		context.registerShutdownHook();
		
//		System.out.println("-----------------------------------------");
//		Pepsi pepsi1 = (Pepsi) context.getBean("pepsi1");
//		System.out.println(pepsi1);
		
		System.out.println("-----------------------------------------");
		Chips chips1 = (Chips) context.getBean("chips1");
		System.out.println(chips1);
	}

}
