package com.interview.design.elevator.control;

import java.util.List;

import com.interview.design.elevator.model.Elevator;


public interface ElevatorControlSystem {
	public List<Elevator> getElevators();
	public void pickUp(int pickUpFloor);
	public void addDestination(int elevatorId, int destinationFloor);
	public boolean step();
}
