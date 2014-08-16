package com.interview.designpattern.state;

public class StateContext {
	private State currentState;
 
	public StateContext(){
		currentState = new Poor();
	}
 
	public void changeState(State newState){
		this.currentState = newState;
	}
 
	public void saySomething(){
		this.currentState.saySomething(this);
	}
}