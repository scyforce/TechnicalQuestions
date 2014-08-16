package com.interview.leetcode;

/**

	Given an array of integers, every element appears twice except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * @author shuchun.yang
 *
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
        assert A.length > 0;
        int number = A[0];
        for (int i=1; i<A.length; i++) {
            number =  number ^ A[i];
        }
        return number;
    }
	
	public static void main(String[] args) {
		SingleNumber single = new SingleNumber();
		int[] array = {1,1,4,3,5,5,4};
		
		System.out.println(single.singleNumber(array));
		
		System.out.println(3>>1);

	}

}
