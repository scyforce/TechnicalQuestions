package com.interview.puzzle.u2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class U2StateProcessor {
    
	public static Map<String, Integer> U2SpeedMap = new HashMap<String, Integer>();
	
	static {
		U2SpeedMap.put(U2Constants.U2_BONO, U2Constants.ONE_MIN);
		U2SpeedMap.put(U2Constants.U2_EDGE, U2Constants.TWO_MINS);
		U2SpeedMap.put(U2Constants.U2_ADAM, U2Constants.FIVE_MINS);
		U2SpeedMap.put(U2Constants.U2_LARRY, U2Constants.TEN_MINS);
	}
	
	public static final U2State initialState = new U2State()
	                                           .setLeftbank(new String[]{U2Constants.U2_BONO,U2Constants.U2_EDGE,U2Constants.U2_ADAM,U2Constants.U2_LARRY})
	                                           .setRightbank(new String[]{})
	                                           .setDepth(1)
	                                           .setParent(null)
	                                           .setFlashlight(U2State.FLASH_LIGHT_STATE.LEFT)
	                                           .setTimeElapsed(0);
	
	public static final U2State finalState = new U2State()
	                                         .setRightbank(new String[]{U2Constants.U2_BONO,U2Constants.U2_EDGE,U2Constants.U2_ADAM,U2Constants.U2_LARRY})
	                                         .setLeftbank(new String[]{})
	                                         .setTimeElapsed(U2Constants.TIME_ALLOWED);
	
	
	public boolean equals(U2State currentState, U2State nextState) {
		Arrays.sort(currentState.leftbank);
		Arrays.sort(nextState.leftbank);
		Arrays.sort(currentState.rightbank);
		Arrays.sort(nextState.rightbank);
		boolean hasSameLeft = Arrays.equals(currentState.leftbank, nextState.leftbank);
		boolean hasSameRight = Arrays.equals(currentState.rightbank, nextState.rightbank);
    	boolean hasSameDepth = (currentState.depth == nextState.depth);
		boolean hasSameFValue = (currentState.fvalue == nextState.fvalue);
    	
		return hasSameLeft && hasSameRight && hasSameDepth && hasSameFValue;
    }
    
    public boolean lessThan (U2State currentState, U2State nextState) {
    	return currentState.fvalue<nextState.fvalue;
    }
    
    public boolean greaterThan (U2State currentState, U2State nextState) {
    	return currentState.fvalue>nextState.fvalue;
    }
    
    public boolean lessThanEquals (U2State currentState, U2State nextState) {
    	return currentState.fvalue<=nextState.fvalue;
    }
    
    public boolean greaterThanEquals (U2State currentState, U2State nextState) {
    	return currentState.fvalue>=nextState.fvalue;
    }
    
    public boolean isGoal (U2State currentState) {
    	Arrays.sort(currentState.rightbank);
    	Arrays.sort(finalState.rightbank);
    	boolean ruleOne = Arrays.equals(currentState.rightbank, finalState.rightbank);
    	boolean ruleTwo = Arrays.equals(currentState.leftbank, finalState.leftbank);
    	boolean ruleThree = (currentState.flashlight == U2State.FLASH_LIGHT_STATE.RIGHT);
    	boolean ruleFour = (currentState.timeElapsed<=finalState.timeElapsed);
    	
    	return ruleOne&&ruleTwo&&ruleThree&&ruleFour;
    }
    
    public boolean isFailure(U2State currentState) {
    	return currentState.timeElapsed>finalState.timeElapsed;
    }
    
    public List<U2State> getSuccessors(U2State currentState) {
    	U2State.FLASH_LIGHT_STATE flashLight = U2State.FLASH_LIGHT_STATE.LEFT;
    	String[] from = currentState.getRightbank();
    	String[] to = currentState.getLeftbank();
    	if (currentState.flashlight == flashLight) {
    		flashLight = U2State.FLASH_LIGHT_STATE.RIGHT;
    		from = currentState.getLeftbank();
    		to = currentState.getRightbank();
    	}
    	List<U2State> successors = new ArrayList<U2State>();
    	handleOnePerson(successors, flashLight, from, to, currentState);
    	handleTwoPerson(successors, flashLight, from, to, currentState);
    	
    	return successors;
    }
    
    public void handleOnePerson(List<U2State> successors, U2State.FLASH_LIGHT_STATE flashLight, String[] from, String[] to, U2State currentState) {
    	for (String name : from) {
    		U2State u2 = new U2State();
    		int time = U2SpeedMap.get(name);
    		String[] newFrom = U2StateHelper.processFrom(from, new String[]{name});
    		String[] newTo = U2StateHelper.processTo(to, new String[]{name});
    		if (currentState.flashlight == U2State.FLASH_LIGHT_STATE.LEFT) {   			
    			u2.setLeftbank(newFrom)
    			  .setRightbank(newTo);
    			  
    		} else {
    			u2.setLeftbank(newTo)
  			      .setRightbank(newFrom);
    		}
    		u2.setParent(currentState)
			  .setTimeElapsed(currentState.timeElapsed+time)
			  .setFlashlight(flashLight)
			  .setDepth(currentState.depth+1);
    		successors.add(u2);
    	}
    }
    
    public void handleTwoPerson(List<U2State> successors, U2State.FLASH_LIGHT_STATE flashLight, String[] from, String[] to, U2State currentState) {   	
    	for (int i=0; i<from.length; i++) {
    		String firstPerson = from[i];
    		int firstPersonTime = U2SpeedMap.get(firstPerson);
    		for (int j=i+1; j<from.length; j++) {
    			String secondPerson = from[j];
    			int secondPersonTime = U2SpeedMap.get(secondPerson);
    			int time = 0;
    			if (firstPersonTime>secondPersonTime) {
    				time = firstPersonTime;
    			} else {
    				time = secondPersonTime;
    			}
    			U2State u2 = new U2State();
    			String[] newFrom = U2StateHelper.processFrom(from, new String[]{firstPerson,secondPerson});
        		String[] newTo = U2StateHelper.processTo(to, new String[]{firstPerson,secondPerson});
        		if (currentState.flashlight == U2State.FLASH_LIGHT_STATE.LEFT) {   			
        			u2.setLeftbank(newFrom)
        			  .setRightbank(newTo);
        			  
        		} else {
        			u2.setLeftbank(newTo)
      			      .setRightbank(newFrom);
        		}
        		u2.setParent(currentState)
    			  .setTimeElapsed(currentState.timeElapsed+time)
    			  .setFlashlight(flashLight)
    			  .setDepth(currentState.depth+1);
        		successors.add(u2);
    		}
    	}
    }
       
    public static void main (String[] args) {
    	U2StateProcessor processor = new U2StateProcessor();
    	List<U2State> successors = processor.getSuccessors(U2StateProcessor.initialState);
    	for (U2State successor : successors) {
    		System.out.println(successor.toString());
    	}
    }
    
}
