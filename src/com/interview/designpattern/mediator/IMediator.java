package com.interview.designpattern.mediator;

/*
 * Mediator design pattern is used to collaborate a set of colleagues. 
 * 
 * Those colleagues do not communicate with each other directly, but through the mediator.
 */
interface IMediator {
	public void fight();
	public void talk();
	public void registerA(ColleagueA a);
	public void registerB(ColleagueB a);
}