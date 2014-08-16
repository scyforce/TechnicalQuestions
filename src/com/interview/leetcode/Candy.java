package com.interview.leetcode;

/**

	There are N children standing in a line. Each child is assigned a rating value.
	
	You are giving candies to these children subjected to the following requirements:
	
	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?

 * @author shuchun.yang
 *
 */
public class Candy {
	public static void main(String[] args) {
		Candy c = new Candy();
		int[] ratings = {1,2,3,4,5};
		System.out.println(c.candy(ratings));
		
		int[] ratings1 = {5,4,3,2,1};
		System.out.println(c.candy(ratings1));
		
		int[] ratings2 = {1,2,3,2,1};
		System.out.println(c.candy(ratings2));
		
		int[] ratings3 = {1,10,3,25,1};
		System.out.println(c.candy(ratings3));
		
		int[] ratings4 = {2,2};
		System.out.println(c.candy(ratings4));
		
	}
	
	public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0) {
        	return 0;
        }
        
        int[] results = new int[ratings.length];
        
        //two folds, first scan from left to right, then scan from right to left to fix any numbers
        int previous = ratings[0];
        results[0] = 1;
        for (int i=1; i<ratings.length; i++) {
        	if (ratings[i]>previous) {
        		results[i] = results[i-1] + 1;
        	} else {
        		results[i] = 1;
        	}
        	previous = ratings[i];
        }
        
        previous = ratings[ratings.length-1];
        for (int i=ratings.length-2; i>=0; i--) {
        	if (ratings[i]>previous && results[i]<=results[i+1]) {
        		results[i] = results[i+1] + 1;
        	}
        	previous = ratings[i];
        }
        
        int result = 0;
        for (int i=0; i<results.length; i++) {
        	result+=results[i];
        }
        return result;
    }
}
