package com.interview.leetcode;

/**

	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
	
	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	
	Note:
	You are not suppose to use the library's sort function for this problem.
	
	click to show follow up.
	
	Follow up:
	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
	
	Could you come up with an one-pass algorithm using only constant space?

 * @author shuchun.yang
 *
 */
public class SortColors {
	public static void main(String[] args) {
		SortColors s = new SortColors();
		s.sortColors(new int[]{0});
	}
	
	public void swap(int[]A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	//one pass
	public void sortColors(int[] A) {
		if (A==null) {
			return;
		}
		
		int redIndex = 0;
		int blueIndex = A.length-1;
		int i=0;
		//if i passes blueIndex, it means the rest array are all blue
		while (i<=blueIndex) {
			if (A[i]==0) {
				swap(A, i, redIndex);
				i++;
				redIndex++;
			} else if (A[i]==2) {
				swap(A, i, blueIndex);
				blueIndex--;
			} else {
				i++;
			}
		}
	}
	
	//two pass
	public void sortColorsNaive(int[] A) {
        if (A==null) {
        	return;
        }
		
		int [] counts = {0,0,0};
        
		for (int i=0; i<A.length; i++) {
			if (A[i]==0) {
				counts[0]++;
			} else if (A[i]==1) {
				counts[1]++;
			} else if (A[i]==2){
				counts[2]++;
			}
		}
		
		int index = 0;
		for (int j=0; j<counts[0]; j++) {
			A[index++] = 0;
		}
	
		for (int j=0; j<counts[1]; j++) {
			A[index++] = 1;
		}
		
		for (int j=0; j<counts[2]; j++) {
			A[index++] = 2;
		}
        
    }
}
