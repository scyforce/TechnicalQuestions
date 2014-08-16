package com.interview.designpattern.command;

/* The Receiver class */
class Computer {
	public void shutDown() {
		System.out.println("computer is shut down");
	}

	public void restart() {
		System.out.println("computer is restarted");
	}
}