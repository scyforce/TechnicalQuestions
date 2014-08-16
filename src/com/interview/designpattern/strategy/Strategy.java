package com.interview.designpattern.strategy;

//Also called as policy pattern
//He doesn't know what kind of police would stop him, until he actually gets caught, that is, run-time. 
//This is the whole point of Strategy pattern.
public interface Strategy {
	//defind a method for police to process speeding case.
	public void processSpeeding(int speed);
}
