package com.interview.designpattern.bridge;

/**

	In brief, Bridge Design Pattern is a two layer abstraction.
	
	The bridge pattern is meant to “decouple an abstraction from its implementation so that the two can vary independently”. 
	
	The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.

 * @author shuchun.yang
 *
 */
public class BridgeExample {

	public static void main(String[] args) {
		ITV tv = new SamsungTV();
		LogitechRemoteControl lrc = new LogitechRemoteControl(tv);
		lrc.setChannelKeyboard(100);
		lrc.turnOn();
		lrc.turnOff();
	}

}
