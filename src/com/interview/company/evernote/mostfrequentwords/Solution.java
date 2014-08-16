package com.interview.company.evernote.mostfrequentwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File input = new File("/Users/shuchun.yang/Dropbox/InterviewQuestions/data/evernote/sample2.dat");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String line = "";
		int lineNumber = 0;
		
		int lines = 0;
		
		Map<String, Integer> frequencyMap = new TreeMap<String, Integer>();
		
		while ((line = reader.readLine())!=null) {
			line = line.trim();
			if (lineNumber == 0) {
				lines = Integer.parseInt(line);
			} else {
				try {
					int output = Integer.parseInt(line);
					List<Entry<String, Integer>> finalList = new ArrayList<Entry<String, Integer>>();
					
					for (Entry<String, Integer> entry : frequencyMap.entrySet()) {
						finalList.add(entry);
					}
					
					Collections.sort(finalList, new Comparator<Entry<String, Integer>>() {

						@Override
						public int compare(Entry<String, Integer> o1,
								Entry<String, Integer> o2) {
							if (o1.getValue().intValue()>o2.getValue().intValue()) {
								return -1;
							} else if (o1.getValue().intValue() == o2.getValue().intValue()) {
								return 0;
							} else {
								return 1;
							}
						}
						
					});
					
					
					for (Entry<String, Integer> entry : finalList) {
						if (output>0) {
							System.out.println(entry.getKey());
						} else {
							break;
						}
						output--;
					}
				} catch (Exception e) {
					if (lines>0) {
						Integer frequency = frequencyMap.get(line);
						if (frequency == null) {
							frequencyMap.put(line, 0);
						} else {
							frequencyMap.put(line, frequency.intValue()+1);
						}
						lines--;
					}
				}			
			}
			lineNumber++;
			
		}
		
		if (reader!=null) {
			reader.close();
		}
	}

}
