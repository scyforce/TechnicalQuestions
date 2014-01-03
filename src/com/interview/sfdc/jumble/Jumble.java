package com.interview.sfdc.jumble;

import java.util.*;

public class Jumble {
    public Map<Integer,List<String>> dictionary;
    
    public Jumble() {
    	this.dictionary = new HashMap<Integer,List<String>>();
    }
    
    public void buildDictionary(String line) {
    	int length = line.length();
    	List<String> words = dictionary.get(length);
    	if (words==null) {
    		words = new ArrayList<String>();
    		dictionary.put(length, words);
    	}
    	words.add(line);
    }
    
    public boolean isSeparator(String line) {
    	return "XXXXXX".equals(line);
    }
    
    public String match(String line) {
    	int length = line.length();
    	List<String> words = dictionary.get(length);
    	List<String> results = new ArrayList<String>();
    	for (String word : words) {
    		if (JumbleUtil.equals(line, word)) {
    			results.add(word);
    		}
    	}
    	return JumbleUtil.output(results);
    }
}
