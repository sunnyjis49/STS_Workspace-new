package com.sun.springcore.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee{
	@Autowired
	@Qualifier("address1")
	private Address address;
	
	public Employee() {
		super();
		System.out.println("Inside default emp constructor");
	}

	
	public Employee(Address address) {
		super();
		this.address = address;
		System.out.println("Inside parameterized emp constructor");
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		System.out.println("Setting address inside employee");
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
	
}
