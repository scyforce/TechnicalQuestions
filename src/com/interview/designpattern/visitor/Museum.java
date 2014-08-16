package com.interview.designpattern.visitor;

class Museum implements Element {
	@Override
	public void accept(Visitor visitor) {
		System.out.println("Museum is accepting visitor.");
		visitor.visit(this);
	}
}