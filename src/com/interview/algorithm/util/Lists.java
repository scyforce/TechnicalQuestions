package com.interview.algorithm.util;

import java.util.Arrays;
import java.util.List;

public class Lists {
	public static void printListOfList(List<List<Integer>> results) {
		for (List<Integer> result : results) {
			System.out.println(Arrays.toString(result.toArray()));
		}		
	}
}
