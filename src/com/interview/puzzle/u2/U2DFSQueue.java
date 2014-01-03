package com.interview.puzzle.u2;

import java.util.ArrayList;
import java.util.List;

//DFS uses Stack
public class U2DFSQueue implements U2SearchQueue {
    public List<U2State> states;
	
	public U2DFSQueue() {
		states = new ArrayList<U2State>();
	}
	
	@Override
	public void push(U2State state) {
		this.states.add(state);
	}
	
	@Override
	public U2State pop() {
		return this.states.remove(states.size()-1);
	}
	
	@Override
	public boolean isEmpty() {		
		return this.states.isEmpty();
	}
}
