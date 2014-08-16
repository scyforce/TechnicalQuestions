package com.interview.designpattern.builder;

//director to encapsulate the builder
class Waiter {
	private StarbucksBuilder starbucksBuilder;

	public void setStarbucksBuilder(StarbucksBuilder builder) {
		starbucksBuilder = builder;
	}

	public Starbucks getstarbucksDrink() {
		return starbucksBuilder.getStarbucks();
	}

	public void constructStarbucks() {
		starbucksBuilder.buildDrink().buildSize();
	}
}