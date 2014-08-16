package com.interview.leetcode;

/**

	Given an array of integers, every element appears three times except for one. Find that single one.

	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * @author shuchun.yang
 *
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
		int result = 0;      
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
            	//把那一位移至第一位然后统计有多少个1
                count += ((A[j] >> i) & 1); 
            }
            //对3取余，
            //001<<0 = 001, 000 | 001 = 001
            //001<<1 = 010, 001 | 010 = 011
            result |= ((count % 3) << i);
        }       
        return result;   
    }
	
	
	public static void main(String[] args) {
		SingleNumberII single = new SingleNumberII();
		int[] array = {1,1,1,3,3,3,4};
		
		System.out.println(single.singleNumber(array));
	}

}
