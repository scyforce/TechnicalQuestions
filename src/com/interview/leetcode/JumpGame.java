package com.interview.leetcode;

/**

	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.

 * @author shuchun.yang
 *
 */
public class JumpGame {
	public static void main(String[] args) {
		int[] A = {4,0,4,2,2,0,1,3,3,0,3};
		JumpGame j = new JumpGame();
		System.out.println(j.canJump(A));
	}
	
	//key is try to find the max A[i] + i
	public boolean canJump(int[] A) {
        if (A==null||A.length==0) {
        	return false;
        }
		
        int index = 0;    	 
        while (index<A.length-1) {
        	int maxPos = 0;
        	//save current index
        	int currentIndex = index;
        	for (int i=1; i<=A[currentIndex]; i++) {
        		int jumpIndex = currentIndex+i;
        		if (jumpIndex == A.length-1) {
        			return true;
        		} 
        		
        		//skip 0
        		if (A[jumpIndex]!=0) {
        			int newMax = A[currentIndex+i]+currentIndex+i;
        			if (newMax>maxPos) {
        				index = currentIndex+i;
        				maxPos = newMax;
        			}
        		}
        	}   
        	if (currentIndex == index) {
        		return false;
        	}
        }    
        //if pass through the end of the array, jump!
        return true;		
    }
}
