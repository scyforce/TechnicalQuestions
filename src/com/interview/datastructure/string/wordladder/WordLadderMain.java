package com.interview.datastructure.string.wordladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadderMain {
	//TODO - find all paths
	public void search(String start, String end, String[] dictionary) {
   	 	List<Word> queue = new ArrayList<Word>();
   	 	Word startWord = new Word(start, null);
   	 	queue.add(startWord);
   	 	
   	 	Map<String, Boolean> visitedMap = new HashMap<String, Boolean>();
   	 	while (!queue.isEmpty()) {
   	 		Word currentWord = queue.remove(0);
   	 		System.out.println(currentWord);
   	 		if (currentWord.value.equals(end)) {
   	 			printSolution(currentWord);
   	 			//queue.add(startWord);
   	 		} else {
   	 			visitedMap.put(currentWord.value, true);
   	 			List<Word> children = WordLadderHelper.getChildren(currentWord, dictionary);
   	 			for (Word word : children) {
   	 				boolean visited = (visitedMap.get(word.value)==null?false:visitedMap.get(word.value).booleanValue());
   	 				if (!visited) {
   	 				    queue.add(word);
   	 				}
   	 			}
   	 		} 	 		
   	 	}
	}
	
	public void printSolution(Word word) {
		List<String> path = new ArrayList<String>();
		path.add(word.value);
		while(word.parent!=null) {		
			word = word.parent;
			path.add(word.value);
		}
		Collections.reverse(path);
		System.out.print(Arrays.toString(path.toArray()));
	}
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String[] dictionary = {"hit","hot","dot","dog","lot","log","cog"};
		WordLadderMain main = new WordLadderMain();
		main.search(start, end, dictionary);
	}
}
