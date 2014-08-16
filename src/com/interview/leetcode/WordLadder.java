package com.interview.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**

	Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
	
	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example,
	
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
	Note:
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.

 * @author shuchun.yang
 *
 */
public class WordLadder {
	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		String start = "hot";
		String end = "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hog");
		//dict.add("dot");
		dict.add("dog");
		//dict.add("lot");
		//dict.add("log");
		
		System.out.println(w.ladderLength1(start, end, dict));
	}
	
	
	public int ladderLength1(String start, String end, HashSet<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		
		queue.add(start);
		
		dict.add(end);
		dict.remove(start);
		while (!queue.isEmpty()) {
			String wordPath = queue.poll();
			String[] words = wordPath.split(" ");
			String current = words[words.length-1];
			
			if (current.equals(end)) {
				return words.length;
			} else {
				for (int i=0; i<current.length(); i++) {
					StringBuilder builder = new StringBuilder(current);
					for (char j='a'; j<='z'; j++) {
						builder.setCharAt(i, j);
						String next = builder.toString();
						if (dict.contains(next)) {
							queue.add(wordPath + " " + next);
							dict.remove(next);
						}
					}
				}
			}			
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
		
		queue.add(start);
		//make sure the end is in dict
		dict.add(end);
		dict.remove(start);
		while (!queue.isEmpty()) {
			String wordPath = queue.poll();
			String[] words = wordPath.split(" ");
			String current = words[words.length-1];
			if (current.equals(end)) {				
				return words.length;
			} else {
				for (int i=0; i<current.length(); i++) {
					StringBuilder newWordBuilder = new StringBuilder(current);
					for (char j='a'; j<='z'; j++) {
						newWordBuilder.setCharAt(i, j);
						String newWord = newWordBuilder.toString();
						if (dict.contains(newWord)) {
							queue.add(wordPath+ " " +newWord);
							dict.remove(newWord);
						}
					}
				}
			}
		}
		
		return 0;
    }
}
