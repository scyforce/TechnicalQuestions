package com.interview.evernote.mostfrequentwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FrequencySet {
	Map<Integer, Set<String>> frequencyWordMap;
	Map<String, Integer> wordCountMap;
	
	public FrequencySet () {
		frequencyWordMap = new TreeMap<Integer, Set<String>>(new Comparator<Integer>(){
			@Override
			public int compare(Integer key1, Integer key2) {
				if (key1>key2) {
					return -1;
				} else if (key1<key2) {
					return 1;
				} else {
					return 0;
				}
			} 
	    });
		wordCountMap = new HashMap<String, Integer>();
	}
	
	
	public void add(String word) {
		Integer count = wordCountMap.get(word) == null ? 0 : wordCountMap.get(word);
		int newCount = count+1;
		wordCountMap.put(word, newCount);
		
		Set<String> oldWords = frequencyWordMap.get(count);
		if (oldWords!=null) {
			oldWords.remove(word);
		}
		Set<String> newWords = frequencyWordMap.get(newCount);
		if (newWords==null) {
			newWords = new HashSet<String>();
			frequencyWordMap.put(newCount, newWords);
		}
		newWords.add(word);		
	}
	
	public List<String> getTopNWords(int n) {
		List<String> words = new ArrayList<String>();
		for (Entry<Integer, Set<String>> entry: frequencyWordMap.entrySet()) {
			if (words.size()>=n) {
				break;
			}
			words.addAll(entry.getValue());			
		}		
		return words;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FrequencySet s = new FrequencySet();
		for (int i=0; i<10; i++) {
			s.add("A");
		}
		for (int i=0; i<6; i++) {
			s.add("B");
		}
		for (int i=0; i<3; i++) {
			s.add("C");
		}
		for (int i=0; i<9; i++) {
			s.add("D");
		}
		for (int i=0; i<15; i++) {
			s.add("E");
		}
		for (int i=0; i<2; i++) {
			s.add("F");
		}
		System.out.println(Arrays.toString(s.getTopNWords(2).toArray()));

	}

}
