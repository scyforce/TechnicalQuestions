package com.interview.design.elevator.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interview.design.elevator.control.ElevatorAction;
import com.interview.design.elevator.control.ElevatorControlSystem;
import com.interview.design.elevator.model.Elevator;

public class ElevatorControlSystemImpl implements ElevatorControlSystem{
	private int numberOfElevators = 0;
	private List<Elevator> elevators;
	private Queue<Integer> pickupLocations;
	private ElevatorAction action;

	public ElevatorControlSystemImpl(Integer numberOfElevators, ElevatorAction action)  {
	    this.numberOfElevators = numberOfElevators;
	    initializeElevators();
	    this.pickupLocations = new LinkedList<Integer>();
	    this.action = action;
	}

	private void initializeElevators(){
		elevators = new ArrayList<Elevator>();
	    for (int id=0;id<this.numberOfElevators;id++){
	      elevators.add(new Elevator(id, 1));
	    }
	}
	
	@Override
	public List<Elevator> getElevators(){
	    return elevators;
	}

	@Override
	public void pickUp(int pickUpFloor) {
		pickupLocations.add(pickUpFloor);
	}

	@Override
	public void addDestination(int elevatorId, int floor) {
	    action.addDestination(elevators.get(elevatorId), floor);
	}

	@Override
	public boolean step() {
		boolean elevatorInUse = false;
		
	    // Loop though every elevator
	    for (Elevator currElevator : elevators){
	      // Check to figure out which ones are unoccupied and update call
	      switch (currElevator.getStatus()){
	        case ELEVATOR_EMPTY:
            	action.standBy(currElevator);
	        	if (!pickupLocations.isEmpty()) {
	        	  int floorRequest = pickupLocations.poll();
	        	  action.addDestination(currElevator, floorRequest);
	        	  System.out.println(String.format("Elevator %d gets request on floor %d", currElevator.getId(), floorRequest));
	        	  simulateElevators(currElevator.getId());
	        	  elevatorInUse = true;
	          }	            
	          break;
	        // Move occupied Elevators one step closer to next closest destination in direction
	        case ELEVATOR_OCCUPIED:
	          switch (currElevator.getDirection()){
	            case ELEVATOR_UP:
	            	action.moveUp(currElevator);
	            	elevatorInUse = true;
	            	break;
	            case ELEVATOR_DOWN:
	            	action.moveDown(currElevator);
	            	elevatorInUse = true;
	            	break;
	            case ELEVATOR_STAND:
	            	// TODO: Check timer here to alert users that they are holding the door open to long
	            	// TODO: Emergency situation where elevator can't be used
	            	// TODO: Maintenance Mode e.g. movers or maintenance people
	            	// action.removeDestination(currElevator);
	            	break;
	          }
	      }
	   }
	   return elevatorInUse;
	}
	
	private void simulateElevators(int elevatorId) {
		Elevator currElevator = this.elevators.get(elevatorId);
		if (elevatorId==0) {
			action.addDestination(currElevator, 4);
			action.addDestination(currElevator, 5);
			action.addDestination(currElevator, 6);
			action.addDestination(currElevator, 7);
			action.addDestination(currElevator, 8);
		} else if (elevatorId==1) {
			action.addDestination(currElevator, 1);
			action.addDestination(currElevator, 8);
		} else if (elevatorId==2) {
			action.addDestination(currElevator, 3);
			action.addDestination(currElevator, 1);
		}
	}
	
}
