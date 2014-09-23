package com.interview.company.linkedin;

public class FindMinimumWordIndex {
	public static void main(String[] args) {
		String[] words = {"this", "is", "a", "is", "fox", "happy"};
		FindMinimumWordIndex f = new FindMinimumWordIndex();
		
		System.out.println(f.findMinimunWordIndx(words, "is", "fox"));	
	}
	
	
	public int findMinimunWordIndx(String[] words, String word1, String word2) {
		int index1 = -1;
		int index2 = -1;
		int minIndex = Integer.MAX_VALUE;
		
		for (int i=0; i<words.length; i++) {
			String currentWord = words[i];			
			if (word1.equals(currentWord)) {
				index1 = i;
			}
			
			if (word2.equals(currentWord)) {
				index2 = i;
			}
			
			if (index1!=-1&&index2!=-1) {
				minIndex = Math.min(minIndex, Math.abs(index2-index1));
			}		
		}
		
		return minIndex > 0 ? minIndex : -1;
	}
}
