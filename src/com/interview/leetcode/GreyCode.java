package com.interview.leetcode;

import java.util.ArrayList;

/**

	The gray code is a binary numeral system where two successive values differ in only one bit.
	
	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
	
	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	
	00 - 0
	01 - 1
	11 - 3
	10 - 2
	Note:
	For a given n, a gray code sequence is not uniquely defined.
	
	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	
	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 * @author shuchun.yang
 *
 */
public class GreyCode {
	/*
	 * Binary Code ：1011 要转换成Gray Code
　　	   1011 = 1（照写第一位）, 1(第一位与第二位异或 1^0 = 1), 1(第二位异或第三位， 0^1=1), 0 (1^1 =0) = 1110
　　    其实就等于 (1011 >> 1) ^ 1011 = 1110
	 */
	public ArrayList<Integer> grayCode(int n) {
        int number = 1<<n;
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i=0; i<number; i++) {
        	results.add((i>>1)^i);
        }
        return results;
    }
	
	public static void main(String[] args) {
		System.out.println((1>>1)^1);
	}
}
