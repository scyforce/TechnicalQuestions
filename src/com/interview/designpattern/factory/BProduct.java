package com.interview.designpattern.factory;

class BProduct implements Product{
	@Override
	public void Talk() {
		System.out.println("B is talking...");	
	}
 
	@Override
	public void Walk() {
		System.out.println("B is walking...");
	}
}