package com.interview.designpattern.strategy;

public class NicePolice implements Strategy{
	@Override
	public void processSpeeding(int speed) {
		System.out.println("This is your first time, be sure don't do it again!");		
	}
}
