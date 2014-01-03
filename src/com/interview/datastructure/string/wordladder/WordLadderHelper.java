package com.interview.datastructure.string.wordladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadderHelper {
	public static List<Word> getChildren(Word currentWord, String[] dictionary) {
		List<Word> children = new ArrayList<Word>();
		String value = currentWord.value;
		
		for (String word : dictionary) {
			if (isChild(value, word)) {
				children.add(new Word(word, currentWord));
			}
		}
		return children;
	}
	
	public static boolean isChild(String word1, String word2) {
		if (word1.length() != word2.length() || word1.equals(word2)) {
			return false;
		}
		
		char[] array1 = word1.toCharArray();
		char[] array2 = word2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int diff = 0;
		for (int i=0; i<array1.length; i++) {
			if (diff>1) {
				return false;
			}
			if (array1[i]!=array2[i]) {
				diff++;
			}
		}
		return true;
	}
}
