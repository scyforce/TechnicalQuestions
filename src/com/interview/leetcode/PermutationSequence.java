package com.interview.leetcode;

/**

	The set [1,2,3,É,n] contains a total of n! unique permutations.
	
	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
	
	Note: Given n will be between 1 and 9 inclusive.

 * @author shuchun.yang
 *
 */
public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		String result = p.getPermutation(4, 5);
		System.out.println(result);
	}
	
	//http://yucoding.blogspot.com/2013/04/leetcode-question-68-permutation.html
	public String getPermutation(int n, int k) {
        if (n<1) {
        	return "";
        }
        
        int[] number = new int[n];
        int permutation = 1;
        for (int i=1; i<=n; i++) {
        	//set number from 1..9
        	number[i-1] = i;
        	//calculate n factorial
        	permutation *= i;
        }
        
        //this is important, k starts with 1, but index starts with 0
        k = k-1;
        StringBuilder results = new StringBuilder();
        // Follow the logic: a0 = k/(n-1)! then 
        for (int i=0; i<n; i++) {
        	permutation = permutation/(n-i);           
            int index = k/permutation;
            results.append(number[index]);
            //shift left to replace the used element
            for (int j=index; j<n-i-1; j++) {
            	number[j] = number[j+1];
            }
            k = k%permutation;
        }
        
        return results.toString();
    }
}
