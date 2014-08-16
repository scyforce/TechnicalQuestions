package com.interview.leetcode;

import java.util.Arrays;
import java.util.Random;

import com.interview.algorithm.sort.SortUtils;

/**
 * how to shuffle an array of int
 * 
 * @author shuchun.yang
 *
 */
public class ShuffleAnArray {
	public void perfectShuffle(int[] array) {
		Random rand = new Random();
		for (int i=array.length-1; i>0; i--) {
			int j = rand.nextInt(i+1);
			SortUtils.swap(array, i, j);
		}
		System.out.println(Arrays.toString(array));
	}
	
	//Reservoir sampling is a family of randomized algorithms for randomly choosing a sample of k items from a list S containing n items
	public int[] reservoirSampling(int[] array, int n) {
		assert array.length >= n;
		int[] results = new int[n];
		for (int i=0; i<results.length; i++) {
			results[i] = array[i];
		}
		
		Random rand = new Random();
		for (int i=n; i<array.length; i++) {
			int j = rand.nextInt(i);
			if(j<=n-1) {
				results[j] = array[i];
			}
		}
		return results;
	}
}
