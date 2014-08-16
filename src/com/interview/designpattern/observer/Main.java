package com.interview.designpattern.observer;

public class Main {
	 
	public static void main(String[] args) {
		HeadHunter hh = new HeadHunter();
		hh.registerObserver(new JobSeeker("Mike"));
		hh.registerObserver(new JobSeeker("Chris"));
		hh.registerObserver(new JobSeeker("Jeff"));
 
		//Each time, a new job is added, all registered job seekers will get noticed.
		hh.addJob("Google Job");
		hh.addJob("Yahoo Job");
	}
}
