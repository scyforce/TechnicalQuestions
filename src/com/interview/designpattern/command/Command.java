package com.interview.designpattern.command;

/*
 * Command pattern has 4 parts: command, receiver, invoker and client. 
 * 
 * In this example, Switch is the invoker, and Computer is the receiver. 
 * 
 * A concrete Command has a receiver object and invoke the receiver's method. 
 * 
 * Invoker can use different concrete command. The client determines which command to use for the receiver.
 */
interface Command {
	void execute();
}
