package com.interview.design.elevator.model;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
	private int id;
	private int currentFloor;
	private Queue<Integer> destinations;

	public Elevator(int id, int currentFloor) {
		this.id = id;
		this.currentFloor = currentFloor;
		this.destinations = new LinkedList<Integer>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setCurrentFloor(int floor) {
		this.currentFloor = floor;
	}
	
	public int getNextDestination(){
		return this.destinations.peek();
	}

	public int getCurrentFloor(){
		return this.currentFloor;
	}
	
	public Queue<Integer> getDestinations() {
		return this.destinations;
	}

	public ElevatorDirection getDirection() {
		if (destinations.size() > 0){
			if (currentFloor < getNextDestination()){
				return ElevatorDirection.ELEVATOR_UP;
			} else if (currentFloor > getNextDestination()) {
				return ElevatorDirection.ELEVATOR_DOWN;
			}
		}
		return ElevatorDirection.ELEVATOR_STAND;
	}

	public ElevatorStatus getStatus() {
		return (destinations.size() > 0)?ElevatorStatus.ELEVATOR_OCCUPIED:ElevatorStatus.ELEVATOR_EMPTY;
	}
	
}
