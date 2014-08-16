package com.interview.leetcode;

/**
	
	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Your goal is to reach the last index in the minimum number of jumps.
	
	For example:
	Given array A = [2,3,1,1,4]
	
	The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 * @author shuchun.yang
 *
 */
public class JumpGameII {	
	public static void main(String[] args) {
		int[] A = {1,0};
		JumpGameII j = new JumpGameII();
		System.out.println(j.jump(A));
	}
	
	public int jump(int[] A) {
        if (A==null||A.length==0) {
        	return 0;
        }
        
        int index = 0;
        int steps = 0;
        while (index<A.length-1) {
        	int maxPos = 0;
        	int currentIndex = index;
        	//number of jump times for current elements;
        	for (int i=1; i<=A[currentIndex]; i++) {
        		int jumpIndex = currentIndex + i;
        		if (jumpIndex == A.length-1) {
        			steps = steps + 1;
        			return steps;
        		}
        		
        		if (A[jumpIndex]!=0) {
        			int currentMaxPos = A[jumpIndex] + jumpIndex;
        			if (currentMaxPos>maxPos) {
        				maxPos = currentMaxPos;
        				index = jumpIndex;
        			}
        		}
        	}
        	
        	//if has to jump to a 0 value, then can not jump, return -1;
        	if (currentIndex==index) {
        		return -1;
        	}
        	//otherwise, add the step
        	steps = steps + 1;
        }       
        return steps;
    }
}
