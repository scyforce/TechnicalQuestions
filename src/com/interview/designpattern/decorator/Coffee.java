package com.interview.designpattern.decorator;

//The abstract Coffee class defines the functionality of Coffee implemented by decorator
public abstract class Coffee {
	public abstract double getCost(); // Returns the cost of the coffee

	public abstract String getIngredients(); // Returns the ingredients of the
												// coffee
}
