package com.sun.springcore.lifecycle;

import java.util.concurrent.SynchronousQueue;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean,DisposableBean {
	private double price;

	public Pepsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		System.out.println("Setting pepsi price..");
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}

	public void afterPropertiesSet() throws Exception {
		// similar to init method
		System.out.println("taking pepsi: init");
	}

	public void destroy() throws Exception {
		System.out.println("Disposed the pepsi bottle..");
		
	}
	
	
}
