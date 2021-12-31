package com.sun.springcore.ref;

public class Addition {
	private int x;
	private int y;

	public Addition(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("int : int constructor");
	}

	public Addition(double x, double y) {
		this.x = (int) x;
		this.y = (int) y;
		System.out.println("double : double constructor");
	}
	
	public Addition(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		System.out.println("String : String constructor");
	}
	
	public  void doAddition(){
		System.out.println("x: "+this.x+" y: "+this.y);
		System.out.println("Sum is: "+this.x+this.y);
	}
}
