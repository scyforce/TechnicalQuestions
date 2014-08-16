package com.interview.designpattern.builder;

//abstract builder
abstract class StarbucksBuilder {
	protected Starbucks starbucks;

	public StarbucksBuilder() {
		starbucks = new Starbucks();
		System.out.println("a drink is created");
	}
	
	public Starbucks getStarbucks() {
		return starbucks;
	}

	public abstract StarbucksBuilder buildSize();
	public abstract StarbucksBuilder buildDrink();
}