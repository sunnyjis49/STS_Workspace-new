package com.sun.microservices.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OrderServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceRegistryApplication.class, args);
	}

}
