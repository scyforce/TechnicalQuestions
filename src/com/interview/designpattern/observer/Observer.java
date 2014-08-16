package com.interview.designpattern.observer;

/*
 *  Observer Pattern = publisher + subscriber.
	Observer pattern has been used in GUI action listener. 
	Swing GUI example shows how action listener works like an observer.
 */
public interface Observer {
	public void update(Subject s);
}
