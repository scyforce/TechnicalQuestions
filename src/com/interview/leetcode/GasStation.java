package com.interview.leetcode;

/**

	There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	
	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
	
	Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	
	Note:
	The solution is guaranteed to be unique.

 * @author shuchun.yang
 *
 */
public class GasStation {
	//the goal is to find out start from where to the end, the total leftGas is always positive, 
	//if the leftGas between any station is negative, it is not the starting point.
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int leftGas = 0;
        int sum = 0;
        int startIndex = 0;
        
        //question 1: if there is an answer, the total diff should be greater than 0
        //question 2: from the starting point to next diff, next next diff should all be positive
        //-1 0 -1 1 1
        for (int i=0; i<gas.length; i++) {
        	leftGas += gas[i] - cost[i];
        	sum += gas[i] - cost[i];
        	if (sum<0) {
        		startIndex = i+1;
        		sum = 0;
        	}
        }
        return leftGas>=0?startIndex:-1;       
    }
}
