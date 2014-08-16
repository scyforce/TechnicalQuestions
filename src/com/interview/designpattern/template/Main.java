package com.interview.designpattern.template;

public class Main {
	public static void main(String args[]){
		Car car = new Car();
		testVehicle(car);
 
		Truck truck = new Truck();
		testVehicle(truck);
	}
 
	public static void testVehicle(Vehicle v){
		v.testYourVehicle();
	}
}
