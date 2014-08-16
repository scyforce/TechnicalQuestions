package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
	Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

	You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
	
	Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, 
	
	the empty slots on the left will be assigned more spaces than the slots on the right.
	
	For the last line of text, it should be left justified and no extra space is inserted between words.
	
	For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
	
	Return the formatted lines as:
	[
	   "This    is    an",
	   "example  of text",
	   "justification.  "
	]
	Note: Each word is guaranteed not to exceed L in length.
	
	click to show corner cases.
	
	Corner Cases:
	A line other than the last line might contain only one word. What should you do in this case?
	In this case, that line should be left-justified.
 * @author shuchun.yang
 *
 */
public class TextJustification {
	public static void main(String[] args) {
		TextJustification t = new TextJustification();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int L = 16;
		
		List<String> results = t.fullJustify(words, L);
		for (String result : results) {
			assert result.length() == L;
			System.out.println(result);
		}
	}
	
	private String handleComplex(StringBuilder lineBuilder, int L) {
		//remove last " "
		lineBuilder.deleteCharAt(lineBuilder.length()-1);
		String[] currWords = lineBuilder.toString().split(" ");
				
		int currLength = lineBuilder.length();
		
		//handle the corner case, this line only contains one word
		if (currWords.length==1) {
			int spaces = L - currWords[0].length();
			while (spaces>0) {
				lineBuilder.append(" ");
				spaces = spaces - 1;
			}			
		} else {
			int spaces = (L-currLength) / (currWords.length-1);
			int additionalSpaces = (L-currLength) % (currWords.length-1);
			//clear string builder
			lineBuilder.setLength(0);
			for (int i=0; i<currWords.length; i++) {
				lineBuilder.append(currWords[i]);
				//if there are three words, there will only be two gaps
				//do not add spaces for last word
				if (i+1<currWords.length) {
					lineBuilder.append(" ");
					for (int j=0; j<spaces; j++) {
						lineBuilder.append(" ");
					}
				}
				
				//additional spaces should be added for each gap
				if (additionalSpaces>0) {
					lineBuilder.append(" ");
					additionalSpaces--;
				}
			}
		}
		return lineBuilder.toString();
	}
	
	public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> results = new ArrayList<String>();
        if (words==null||words.length==0) {
        	return results;
        }
        
        
        StringBuilder lineBuilder = new StringBuilder();
        int index=0;
        while (index<words.length) {
        	String curr = words[index];
        	//perfect with the current word
        	if (lineBuilder.length() + curr.length() == L) {
        		lineBuilder.append(curr);
    			results.add(lineBuilder.toString());
    			lineBuilder.setLength(0);
        	} else if (lineBuilder.length() + curr.length() < L){
        		lineBuilder.append(curr + " ");
        	} else {
        		String line = handleComplex(lineBuilder, L);
       		
    			results.add(line);
    			lineBuilder.setLength(0);
    			
    			lineBuilder.append(curr + " ");
        	}
        	index = index+1;
        }
        
        //handle last line
        if (lineBuilder.length()>0) {
        	//remove the last " "
        	lineBuilder.deleteCharAt(lineBuilder.length()-1);
        	if (lineBuilder.length()<L) {       		
        		//last line must be left justified
            	int spaces = L - lineBuilder.length();
            	for (int j=0; j<spaces; j++) {
            		lineBuilder.append(" ");
            	}
        	}        	
        	results.add(lineBuilder.toString());
        }
        return results;
    }
}
