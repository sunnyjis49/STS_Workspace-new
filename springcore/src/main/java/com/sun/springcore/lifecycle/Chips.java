package com.sun.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Chips {
	private double price;

	public Chips() {
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
		System.out.println("setting chips price");
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chips [price=" + price + "]";
	}
	
	@PostConstruct
	public void start(){
		System.out.println("starting method..");
	}
	
	@PreDestroy
	public void end(){
		System.out.println("ending method..");
	}
}
