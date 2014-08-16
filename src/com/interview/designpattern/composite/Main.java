package com.interview.designpattern.composite;

public class Main {

	public static void main(String[] args) {
		Leaf leaf1 = new Leaf("1");
		Leaf leaf2 = new Leaf("2");
		Leaf leaf3 = new Leaf("3");
		Leaf leaf4 = new Leaf("4");
		Leaf leaf5 = new Leaf("5");

		CompositeDemo composite1 = new CompositeDemo();
		composite1.add(leaf1);
		composite1.add(leaf2);

		CompositeDemo composite2 = new CompositeDemo();
		composite2.add(leaf3);
		composite2.add(leaf4);
		composite2.add(leaf5);

		composite1.add(composite2);
		composite1.show();
	}
}
