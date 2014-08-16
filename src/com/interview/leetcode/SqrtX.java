package com.interview.leetcode;

/**

	Implement int sqrt(int x).
	
	Compute and return the square root of x.

 * @author shuchun.yang
 *
 */
public class SqrtX {
	public double sqrt(double num, double accuracy) {
		double middle = (num+1)/2;
		
		while (Math.abs(middle*middle-num)>=accuracy) {
			double nEstimate = num/middle;
			middle = (middle+nEstimate)/2;	
		}
		return middle;
	}
	
	public int sqrt(int x) {
		double accuracy = 0.00001;
		//avoid int overflow
		double middle = 1 + (x-1)/2;
		
		while (Math.abs(middle*middle-x)>=accuracy) {
			double nEstimate = x/middle;
			middle = (middle+nEstimate)/2;
		}
		
		int value = (int) middle;
		if (value*value>x) {
			value = value - 1;
		}
		
		return value;		
	}
	
	public static void main(String[] args) {
		SqrtX s = new SqrtX();
		System.out.println((int)s.sqrt(Integer.MAX_VALUE, 0.00001));
		
		System.out.println(s.sqrt(Integer.MAX_VALUE));
		
		System.out.println(s.sqrt(0));
	}
}
