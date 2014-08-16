package com.interview.designpattern.decorator;

/* Decorator pattern adds additional features to an existing object dynamically.
 */

//Decorator Milk that mixes milk with coffee.
class Milk extends CoffeeDecorator {
	public Milk(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}
	
	// Overriding methods defined in the abstract
	// superclass
	public double getCost() { 
		return super.getCost() + 0.5;
	}

	public String getIngredients() {
		return super.getIngredients() + ingredientSeparator + "Milk";
	}
}
