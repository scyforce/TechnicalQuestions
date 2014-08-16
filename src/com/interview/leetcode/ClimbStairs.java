package com.interview.leetcode;

/**

	You are climbing a stair case. It takes n steps to reach to the top.
	
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	Thoughts:
	This is just Fibonacci numbers. The number of distinct ways for n steps are the sum of distinct ways for n-1
	 (because we can move 1 step first, then move the rest n - 1 steps) 
	 and distinct ways for n - 2 (because we can move 2 steps first, there are two ways to do it: 
	 move 1 steps twice and move 2 steps once, the former is a duplicate for the n - 1 case so we should eliminate).

 * @author shuchun.yang
 *
 */
public class ClimbStairs {
	public int climbStairs1(int n) {
		if (n<=2) {
			if (n==0) {
				return 0;
			} else if (n==1) {
				return 1;
			} else {
				return 2;
			}
		}
		
		int[] steps = {1,2};
		
		while (n>2) {
			int temp = steps[1];
			steps[1] = steps[0] + steps[1];
			steps[0] = temp;
			n--;
		}
		
		return steps[1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//f(n) = f(n-1) + f(n-2); n>2
	public int climbStairs(int n) {
		if (n<=2) {
			if (n<0) {
				return 0;
			} else if (n==1) {
				return 1;
			} else {
				return 2;
			}
    	} else {
    		int[] value = {1,2};
    		int sum = 0;
    		while (n>2) {
    			sum = value[0] + value[1];
    			value[0] = value[1];
    			value[1] = sum;
    			n--;
    		}
    		return sum;
    	}
		
    }
	
	public static void main(String[] args) {
		ClimbStairs c = new ClimbStairs();
		System.out.println(c.climbStairs(6));
		
		System.out.println(c.climbStairs1(6));
	}
}
