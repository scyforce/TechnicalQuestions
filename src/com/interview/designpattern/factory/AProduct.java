package com.interview.designpattern.factory;

class AProduct implements Product{
	@Override
	public void Talk() {
		System.out.println("A is talking...");		
	}
 
	@Override
	public void Walk() {
		System.out.println("A is walking...");
	}
}