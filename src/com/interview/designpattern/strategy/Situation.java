package com.interview.designpattern.strategy;

public class Situation {
	private Strategy strategy;
 
	public Situation(Strategy strategy){
		this.strategy = strategy;
	}
 
	public void handleByPolice(int speed){
		this.strategy.processSpeeding(speed);
	}
}