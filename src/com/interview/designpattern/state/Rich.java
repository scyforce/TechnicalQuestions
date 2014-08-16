package com.interview.designpattern.state;

public class Rich implements State{
	@Override
	public void saySomething(StateContext sc) {
		System.out.println("I'm rick currently, and play a lot.");
		sc.changeState(new Poor());
	}
}
