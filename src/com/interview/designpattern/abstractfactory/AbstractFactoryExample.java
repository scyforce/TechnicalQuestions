package com.interview.designpattern.abstractfactory;


public class AbstractFactoryExample {
    public static void main(String[] args) {
        new Computer(createSpecificFactory());
    }
 
    public static CPUFactory createSpecificFactory() {
        int sys = 0; // based on specific requirement
        if (sys == 0) 
        	return new AMDFactory();
        else 
        	return new IntelFactory();
    }
}