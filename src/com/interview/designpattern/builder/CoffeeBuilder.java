package com.interview.designpattern.builder;

//Concrete builder to build coffee
class CoffeeBuilder extends StarbucksBuilder {
	public StarbucksBuilder buildSize() {
		starbucks.setSize("medium");
		System.out.println("build medium size");
		return this;
	}

	public StarbucksBuilder buildDrink() {
		starbucks.setDrink("coffee");
		System.out.println("build coffee");
		return this;
	}
}