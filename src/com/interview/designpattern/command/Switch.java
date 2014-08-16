package com.interview.designpattern.command;

import java.util.ArrayList;
import java.util.List;

//in this example, suppose you use a switch to control computer

/* The Invoker class */
class Switch {
	private List<Command> history = new ArrayList<Command>();

	public Switch() {
	}

	public void storeAndExecute(Command command) {
		this.history.add(command); // optional, can do the execute only!
		command.execute();
	}
}
