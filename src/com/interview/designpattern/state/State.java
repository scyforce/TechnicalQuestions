package com.interview.designpattern.state;

/*
 * State Design Pattern is mainly for changing state at run-time.
 */
public interface State {
	public void saySomething(StateContext sc);
}

