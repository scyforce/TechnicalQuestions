package com.interview.designpattern.builder;

//produce to be built - StringBuilder
class Starbucks {
	private String size;
	private String drink;

	public void setSize(String size) {
		this.size = size;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public String getDrink() {
		return this.drink;
	}
}