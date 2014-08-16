package com.interview.designpattern.composite;


//leaf
class Leaf implements Component {
	String name;

	public Leaf(String s) {
		name = s;
	}

	public void show() {
		System.out.println(name);
	}
}
