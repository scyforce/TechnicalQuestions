package com.interview.design.elevator;

import com.interview.design.elevator.control.ElevatorAction;
import com.interview.design.elevator.control.ElevatorControlSystem;
import com.interview.design.elevator.impl.ElevatorActionImpl;
import com.interview.design.elevator.impl.ElevatorControlSystemImpl;
import com.interview.design.elevator.model.Elevator;

// code reference from - https://github.com/joeblau/sample-elevator-control-system
public class Main {
	public static void main(String[] args) {
		int numberOfElevators = 10;
		int numberOfFloors = 8;
		
		ElevatorAction action = new ElevatorActionImpl(numberOfFloors);
		ElevatorControlSystem control = new ElevatorControlSystemImpl(numberOfElevators, action);
		
		control.pickUp(3);		
		control.pickUp(2);
		control.pickUp(4);
		control.pickUp(5);
		control.pickUp(8);
		
		boolean isStillBusy = true;
		int floorNumber=1;
		while (isStillBusy) {
			System.out.println("Checking floor " + floorNumber%numberOfFloors + " ---------------------------");
			isStillBusy = control.step();
			System.out.println("-----------------------------------------------------------------------");
			floorNumber++;
		}
		
		for (Elevator elevator : control.getElevators()) {
			System.out.println(String.format("Elevator %d is on floor %d", elevator.getId(), elevator.getCurrentFloor()));
		}
	}
}
