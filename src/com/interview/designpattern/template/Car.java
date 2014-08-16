package com.interview.designpattern.template;

/*
 * The Template Method design pattern defines the workflow for achieving a specific operation. 
 * 
 * It allows the subclasses to modify certain steps without changing the workflow's structure.
 */
public class Car extends Vehicle {	 
	@Override
	void start() {
		this.status = true;
	}
 
	@Override
	void run() {
		System.out.println("Run fast!");
 
	}
 
	@Override
	void stop() {
		System.out.println("Car stop!");
	}
}
