package com.interview.designpattern.template;

public class Truck extends Vehicle {	 
	@Override
	void start() {
		this.status = true;
	}
 
	@Override
	void run() {
		System.out.println("Run slowly!");
	}
 
	@Override
	void stop() {
		System.out.println("Truck stop!");
 
	}
}
