package com.interview.puzzle.u2;

import java.util.Comparator;
import java.util.PriorityQueue;

//A star uses priority queue
public class U2AStarQueue implements U2SearchQueue {
    PriorityQueue<U2State> queue;
    
    public U2AStarQueue () {
    	Comparator<U2State> comparator= new Comparator<U2State>() {
			@Override
			public int compare(U2State state1, U2State state2) {			    
				return (state1.fvalue-state2.fvalue);
			}   		
    	};    	
    	queue = new PriorityQueue<U2State>(1000, comparator);
    }
    
    private int getH(String[] persons) {
		int hValue;
		if (U2StateHelper.contains(persons, U2Constants.U2_LARRY)) {
			hValue = U2StateProcessor.U2SpeedMap.get(U2Constants.U2_LARRY);
		} else if (U2StateHelper.contains(persons, U2Constants.U2_ADAM)) {
			hValue = U2StateProcessor.U2SpeedMap.get(U2Constants.U2_ADAM);
		} else if (U2StateHelper.contains(persons, U2Constants.U2_EDGE)) {
			hValue = U2StateProcessor.U2SpeedMap.get(U2Constants.U2_EDGE);
		} else if (U2StateHelper.contains(persons, U2Constants.U2_BONO)){
			hValue = U2StateProcessor.U2SpeedMap.get(U2Constants.U2_BONO);
		} else {
			hValue = 0;
		}
		return hValue;
	}
    
    @Override
	public void push(U2State state) {
		state.fvalue = state.depth + getH(state.leftbank);
        queue.add(state);
	}

    @Override
	public U2State pop() {
		// TODO Auto-generated method stub
		return queue.poll();
    }	
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty(); 
	}

}
