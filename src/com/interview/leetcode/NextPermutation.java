package com.interview.leetcode;

import java.util.Arrays;

/**

	Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	
	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	
	The replacement must be in-place, do not allocate extra memory.
	
	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 -> 1,3,2
	3,2,1 -> 1,2,3
	1,1,5 -> 1,5,1

 * @author shuchun.yang
 *
 */
public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation n = new NextPermutation();
		int[] num = {1,1};
		
		n.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
	
	/*
	 * Algorithm:
	 * 1. From right to left, find the first digit (PartitionNumber) which violates the increase trend.
	 * 2. From right to left, find the first digit which is greater than the partition number, call it change number
	 * 3. Swap the PartitionNumber and ChangeNumber
	 * 4. Reverse all the digit on the right of partition index
	 */
	public void nextPermutation(int[] num) {
		if (num==null||num.length<2) {
			return;
		}
		
        int partitionNumber = -1;
        int changeNumber = -1;
        
        //step 1 find partition number
        for (int i=num.length-2; i>=0; i--) {
        	if (num[i]<num[i+1]) {
        		partitionNumber = i;
        		break;
        	}
        }
        
        if (partitionNumber!=-1) {
        	//step 2 find change number
        	for (int i=num.length-1; i>partitionNumber; i--) {
            	if (num[i]>num[partitionNumber]) {
            		changeNumber = i;
            		break;
            	}
            }       	
        	//step 3 swap
        	swap(num, partitionNumber, changeNumber);   		
        } 
        //step 4 reverse
        for (int i=partitionNumber+1, j=num.length-1; i<j; i++,j--) {
    		swap(num, i, j);
        }	
    }
	
	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
