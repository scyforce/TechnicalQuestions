package com.interview.designpattern.factory;

public class FactoryExample {
	public static Product createProduct(String m){
		Product p = null;
		if(m.equals("A")){
			p = new AProduct();
		}else if(m.equals("B")){
			p = new BProduct();
		}
		return p;
	}
}

