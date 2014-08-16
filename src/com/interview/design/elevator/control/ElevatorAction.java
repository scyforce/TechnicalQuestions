package com.interview.design.elevator.control;

import com.interview.design.elevator.model.Elevator;

public interface ElevatorAction {
	public void moveUp(Elevator elevator);
	public void moveDown(Elevator elevator);
	public void addDestination(Elevator elevator, int destination);
	public void removeDestination(Elevator elevator);
	public void standBy(Elevator elevator);
}
