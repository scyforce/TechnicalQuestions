package com.interview.puzzle.u2;

import java.util.ArrayList;
import java.util.List;

//BFS use Queue
public class U2BFSQueue implements U2SearchQueue{
	public List<U2State> states;
	
	public U2BFSQueue() {
		states = new ArrayList<U2State>();
	}
	
	@Override
	public void push(U2State state) {
		this.states.add(state);
	}
	
	@Override
	public U2State pop() {
		return this.states.remove(0);
	}
	
	@Override
	public boolean isEmpty() {
		return this.states.isEmpty();
	}	
	
}
