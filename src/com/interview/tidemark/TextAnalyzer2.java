package com.interview.tidemark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class TextAnalyzer2 {
	public String[] words;
	public static Comparator<String> wordComparator = new Comparator<String>() {
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
		
	};	
	
	public TextAnalyzer2() {}
	
	public String[] parseWords(String line) {
		String[] newWords = line.split(" ");
		if (words==null) {
			this.words = newWords;
		//if multiple lines, enlarge the array size and fill in the new words
		} else {
			String[] allWords = Arrays.copyOf(this.words, this.words.length + newWords.length);
			System.arraycopy(newWords, 0, allWords, this.words.length, newWords.length);
			this.words = allWords;
		}
		Arrays.sort(words, wordComparator);
		return words;
	}
	
	public void printWordCount() {
		String previous = null;
		int wordCount = 0;
		int index = 0;
		for (String word : this.words) {
			if (previous!=null && !previous.equals(word)) {
				System.out.printf("%d %s\n", wordCount, previous);
				wordCount = 1;
			} else {
				wordCount++;
			}
			previous = word;
			index++;
			//print the last word in the array
			if (index==words.length) {
				System.out.printf("%d %s\n", wordCount, word);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new FileReader("/Users/shuchun.yang/Dropbox/InterviewQuestions/data/tidemark/data.dat"));
			TextAnalyzer2 solution = new TextAnalyzer2();
			while ((line = reader.readLine())!=null) {
				solution.parseWords(line);
			}
			solution.printWordCount();
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
