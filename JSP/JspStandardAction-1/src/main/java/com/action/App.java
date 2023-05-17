package com.action;

public class App {
	
	
	static {
		System.out.println("Class File Loading");
	}
	
	public App() {
		
		System.out.println("Object Instatiated");
		
	}
	
	public int sqr(int x) {
		
		return x*x;
	}
	
	
	public String hello()
	{
		
		return "Hey! I'm Mangesh Dhande";
	}
	
	
	
	

}
