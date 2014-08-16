package com.interview.designpattern.mediator;

public class MediatorExample {
	public static void main(String[] args) {
		IMediator mediator = new ConcreteMediator();
 
		ColleagueA talkColleague = new ColleagueA(mediator);
		ColleagueB fightColleague = new ColleagueB(mediator);
 
		talkColleague.doSomething();
		fightColleague.doSomething();
	}
}
