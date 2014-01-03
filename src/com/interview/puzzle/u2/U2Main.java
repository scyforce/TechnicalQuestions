package com.interview.puzzle.u2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class U2Main {
     public void search(U2SearchQueue queue, U2State initialState) {
    	 queue.push(initialState);
         Map<U2State, Boolean> stateMap = new HashMap<U2State, Boolean>();
    	 int numOfGenState = 0;
    	 int numOfDeState = 0;
    	 U2StateProcessor processor = new U2StateProcessor();
    	 while (!queue.isEmpty()) {
    		 U2State currentState = queue.pop();
    		 numOfDeState++;
    		 if (processor.isGoal(currentState)) {
    			 printSolution(currentState);
    			 break;
    		 } else {
        		 List<U2State> activeStates = new ArrayList<U2State>();
    			 stateMap.put(currentState, true);
    			 List<U2State> successors = processor.getSuccessors(currentState);
    			 numOfGenState = numOfGenState + successors.size();
    			 for (U2State state : successors) {
    				 boolean hasVisited = (stateMap.get(state)==null ? false : stateMap.get(state).booleanValue());
    				 if (!hasVisited && !processor.isFailure(state)) {
    					 activeStates.add(state);
    				 }    				 
    			 }
    			 for (U2State state : activeStates) {
    				 queue.push(state);
    			 }
    			 //System.out.printf("Dequeued %d states \n", numOfDeState);
    			 //System.out.printf("Generated %d states \n", numOfGenState);    			 
    		 }
    	 }
     }
     
     public void printSolution(U2State finalState) {
    	 System.out.println("Solution ***********");
    	 List<U2State> paths = new ArrayList<U2State>();
    	 U2State currentState = finalState;
    	 while (currentState.parent != null) {
    		 paths.add(currentState);
    		 currentState = currentState.parent;
    	 }
    	 Collections.reverse(paths);
    	 for (U2State state : paths) {
    		 System.out.printf("%s depth = %d \n", state.toString(), state.depth);
    	 }
     }
     
     public static void main (String[] args) {
    	 U2State initialState = U2StateProcessor.initialState;
         System.out.println(">>>>>>>>>>>>>>>>>>>Initial State>>>>>>>>>>>>>>>>>>>>>>>");
    	 System.out.printf("%s depth = %d \n", initialState.toString(), initialState.depth);       
    	 System.out.println(">>>>>>>>>>>>>>>>>>>BFS Search Result>>>>>>>>>>>>>>>>>>>");
    	 long startTime = System.currentTimeMillis();
    	 U2SearchQueue bfs = new U2BFSQueue();        
         U2Main main = new U2Main();
         main.search(bfs, initialState);
         long endTime = System.currentTimeMillis();
         System.out.printf("finish search in %d milliseconds \n", endTime-startTime);
         System.out.println(">>>>>>>>>>>>>>>>>>>DFS Search Result>>>>>>>>>>>>>>>>>>>");
         startTime = System.currentTimeMillis();
         U2SearchQueue dfs = new U2DFSQueue();       
         main.search(dfs, initialState);
         endTime = System.currentTimeMillis();
         System.out.printf("finish search in %d milliseconds \n", endTime-startTime);
         System.out.println(">>>>>>>>>>>>>>>>>>>A* Search Result>>>>>>>>>>>>>>>>>>>");
         startTime = System.currentTimeMillis();
         U2SearchQueue astar = new U2AStarQueue();
         main.search(astar,initialState);
         endTime = System.currentTimeMillis();
         System.out.printf("finish search in %d milliseconds \n", endTime-startTime);
     }
}
