package com.interview.design.elevator.impl;

import com.interview.design.elevator.control.ElevatorAction;
import com.interview.design.elevator.model.Elevator;

public class ElevatorActionImpl implements ElevatorAction{		
	private int numberOfFloors;
	
	public ElevatorActionImpl(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	
	@Override
	public void removeDestination(Elevator elevator){
		elevator.getDestinations().remove();
	}
	  
	@Override
	public void addDestination(Elevator elevator, int floor) {
		elevator.getDestinations().add(floor);
	}
	
	@Override
	public void standBy(Elevator elevator) {
		System.out.println(String.format("Elevator %d is waiting for floor request ...", elevator.getId()));
	}

	@Override
	public void moveUp(Elevator elevator) {
		System.out.println(String.format("Elevator %d is moving up ...", elevator.getId()));
		
		int destination = elevator.getNextDestination();
		int nextFloor = elevator.getCurrentFloor()+1;
		if (nextFloor>numberOfFloors) {
			throw new UnsupportedOperationException("Elevator can not move up, this building only has " + numberOfFloors + " floors.");
		}		
		elevator.setCurrentFloor(nextFloor);
		if (destination==elevator.getCurrentFloor()) {
			System.out.println(String.format("Elevator %d reaches destination floor %d ...", elevator.getId(), destination));
			removeDestination(elevator);
		}
	}

	@Override
	public void moveDown(Elevator elevator) {
		System.out.println(String.format("Elevator %d is moving down ...", elevator.getId()));
		int destination = elevator.getNextDestination();
		int nextFloor = elevator.getCurrentFloor()-1;
		if (nextFloor<1) {
			throw new UnsupportedOperationException("Elevator can not move down, already in the first floor.");
		}		  
		elevator.setCurrentFloor(nextFloor);		
		if (destination==elevator.getCurrentFloor()) {
			System.out.println(String.format("Elevator %d reaches destination floor %d ...", elevator.getId(), destination));
			removeDestination(elevator);
		}
	}

}
