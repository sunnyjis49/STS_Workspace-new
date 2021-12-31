package com.sun.springcore.lifecycle;

public class Samosa {
	private double price;

	public Samosa() {
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
		System.out.println("Setting price");
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}
	// we can give any name
	public void init(){
		System.out.println("Inside init method..");
	}
	// we can give any name
	public void destroy(){
		System.out.println("Inside destroy method...");
	}
}
