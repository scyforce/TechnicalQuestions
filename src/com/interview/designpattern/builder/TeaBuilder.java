package com.interview.designpattern.builder;

//Concrete Builder to build tea
class TeaBuilder extends StarbucksBuilder {
	public StarbucksBuilder buildSize() {
		starbucks.setSize("large");
		System.out.println("build large size");
		return this;
	}

	public StarbucksBuilder buildDrink() {
		starbucks.setDrink("tea");
		System.out.println("build tea");
		return this;
	}

}