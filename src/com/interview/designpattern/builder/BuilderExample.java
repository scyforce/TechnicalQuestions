package com.interview.designpattern.builder;

//customer
public class BuilderExample {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		StarbucksBuilder coffeeBuilder = new CoffeeBuilder();

		//Alternatively you can use tea builder to build a tea
		//StarbucksBuilder teaBuilder = new TeaBuilder();

		waiter.setStarbucksBuilder(coffeeBuilder);
		waiter.constructStarbucks();

		//get the drink built
		Starbucks drink = waiter.getstarbucksDrink();
		System.out.println(drink.toString());
	}
}
