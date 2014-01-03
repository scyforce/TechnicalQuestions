package com.interview.tidemark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Text analyzer class to print out the results 
 * @author shuchun.yang
 */

public class TextAnalyzer {	
	//map to store the word->frequency count
	private Map<String, Integer> wordMap;
	
	public TextAnalyzer() {
		//use an ordered map by passing a comparator
		wordMap = new TreeMap<String, Integer>(new Comparator<String>() {

			@Override
			//comparator for the order or the words (map key)
			public int compare(String o1, String o2) {
				if (o1.length()>o2.length()) {
					return 1;
				} else if (o1.length()<o2.length()) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}		
		});
	}
	
	public void addWordContent(String line) {
		for (String word : line.split(" ")) {
			addSingleWord(word);
		}
	}
	
	//add word to the map
	private void addSingleWord(String word) {
		Integer wordCount = wordMap.get(word);
		if (wordCount==null) {
			wordMap.put(word, 1);
		} else {
			wordMap.put(word, wordCount+1);
		}
	}
	
	//print the report in the specified order
	public void printWordContentReport() {
		for (String word : wordMap.keySet()) {
			System.out.printf("%d %s\n", wordMap.get(word), word);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			TextAnalyzer analyzer = new TextAnalyzer();
			while ((line = reader.readLine())!=null) {
				analyzer.addWordContent(line);
				analyzer.printWordContentReport();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
