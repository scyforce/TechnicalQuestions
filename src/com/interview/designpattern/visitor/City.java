package com.interview.designpattern.visitor;

import java.util.ArrayList;

class City implements Element {
	 
	ArrayList<Element> places = new ArrayList<Element>();
 
	public City() {
		places.add(new Museum());
		places.add(new Park());
	}
 
	@Override
	public void accept(Visitor visitor) {
		System.out.println("City is accepting visitor.");
		visitor.visit(this);
 
		for (Element e : places) {
			e.accept(visitor);
		}
	}
}
