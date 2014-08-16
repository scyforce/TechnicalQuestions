package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**

	Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
	
	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example,
	
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	Return
	  [
	    ["hit","hot","dot","dog","cog"],
	    ["hit","hot","lot","log","cog"]
	  ]
	Note:
	All words have the same length.
	All words contain only lowercase alphabetic characters.

 * @author shuchun.yang
 *
 */
public class WordLadderII {
	public static void main(String[] args) {
		WordLadderII w = new WordLadderII();
		/*String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hit");
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");*/
		
		String start = "nape";
		String end = "mild";
		List<String> list = Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier");
		HashSet<String> dict = new HashSet<String>(list);
		long startT = System.currentTimeMillis();
		for (ArrayList<String> ladder : w.findLadders(start, end, dict)) {
			System.out.println(Arrays.toString(ladder.toArray()));
		}
		long endT = System.currentTimeMillis();
		System.out.println(endT-startT);
	}
	
	private void getNextWords(Map<String, Set<String>> nextWordsMap, String word, HashSet<String> dict) {
        char [] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {           
            char old = chars[i]; 
            for (char c = 'a'; c <= 'z'; c++) {
                //do not add the current word
            	if (c != old)  {
                	chars[i] = c;
                    String nextWord = new String(chars);                
                    
                    if (dict.contains(nextWord)) {
                        Set<String> nextWords = nextWordsMap.get(word);
                        if (nextWords != null) {
                            nextWords.add(nextWord);
                        } else {
                            nextWords = new HashSet<String>();
                            nextWords.add(nextWord);
                            nextWordsMap.put(word, nextWords);
                        }
                    }     
                }                        
            }
            //revert the word back
            chars[i] = old;
        }
    }
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        Queue<String> queue = new LinkedList<String>();
		Map<String, Integer> levelMap = new HashMap<String, Integer>();
		queue.add(start);
		levelMap.put(start, 1);
		//make sure the end is in dict
		dict.add(end);
		
		Map<String, Set<String>> nextWordsMap = new HashMap<String, Set<String>>();
		getNextWords(nextWordsMap, start, dict);
		// init adjacent graph        
        for(String word : dict){
            getNextWords(nextWordsMap, word, dict);
        }
		
		while (!queue.isEmpty()) {
			String wordPath = queue.poll();
			String[] words = wordPath.split(" ");
			String current = words[words.length-1];
			if (current.equals(end)) {				
				ArrayList<String> result = new ArrayList<String>();
				for (String word : words) {
					result.add(word);
				}
				results.add(result);				
			} else {
				Set<String> nextWords = nextWordsMap.get(current);
				if (nextWords!=null) {
					int nextLevel = words.length+1;
					for (String nextWord : nextWords) {
						//if the word has been used before then he can only be added to the same level
						if (levelMap.get(nextWord)==null || nextLevel==levelMap.get(nextWord)) {
							queue.add(wordPath + " " + nextWord);
							if (levelMap.get(nextWord)==null) {
								levelMap.put(nextWord, nextLevel);
							}
						}
					}
				}				
			}
		}

        return results;
    }
}
