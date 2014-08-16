package com.interview.designpattern.singleton;

//http://www.programcreek.com/java-design-patterns-in-stories/
public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return instance;
	}	
}
