package com.interview.leetcode;

/**

	Implement pow(x, n), need O(logN) solution

 * @author shuchun.yang
 *
 */
public class Pow {	 
	public double pow(double x, int n) {
		//2(-1) = 1/2 = 1/2(1);
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}
	
	//best so far
	public double power(double x, int n) {
		if (n == 0)
			return 1;
		//only need to calculate x(n/2) because:
		// x2 = x * x; x4 = x2 * x2;
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
}
