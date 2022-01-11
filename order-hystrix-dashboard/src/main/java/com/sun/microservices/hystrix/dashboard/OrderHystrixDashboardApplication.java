package com.sun.microservices.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@enable
public class OrderHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderHystrixDashboardApplication.class, args);
	}

}
