package com.interview.designpattern.adapter;

/*
 * 
 	Adapter pattern is frequently used in modern Java frameworks.

	It comes into place when you want to use an existing class, and its interface does not match the one you need, 
	
	or you want to create a reusable class that cooperates with unrelated classes with incompatible interfaces.
 */
class Apple {
	public void getAColor(String str) {
		System.out.println("Apple color is: " + str);
	}
}