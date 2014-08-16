package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

    Permutation on string

 * @author shuchun.yang
 *
 */
public class PermutationsIIII {
	public static void main(String[] args) {
		String s = "abcd";
		PermutationsIIII p = new PermutationsIIII();
		ArrayList<String> results = p.permutation(s);
		
		System.out.println(Arrays.toString(results.toArray()));
	}
	
	public ArrayList<String> permutation(String s) { 
		ArrayList<String> results = new ArrayList<String>();		
		if (s==null || s.length()==0) {
			return results;
		}
		
	    permutation(results, "", s);
	    return results;
	}

	private void permutation(ArrayList<String> results, String prefix, String str) {
	    int n = str.length();
	    if (n == 1) {
	    	results.add(prefix+str);
	    } else {
	        for (int i = 0; i < n; i++) {	        	
	        	permutation(results, prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));	
	        }
	    }
	}	
	
	public ArrayList<String> permute(String s) {
		ArrayList<String> results = new ArrayList<String>();		
		if (s==null || s.length()==0) {
			return results;
		}
		
		permute(results, new StringBuilder(), new boolean[s.length()], s, 0);
		
		return results;		
	}
	
	private void permute(ArrayList<String> results, StringBuilder str, boolean[] used, String s, int level) {
		if (level==s.length()) {
			results.add(str.toString());
			return;
		}
		
		for (int i=0; i<s.length(); i++) {
			if (!used[i]) {
				used[i]=true;
				str.append(s.charAt(i));
				permute(results, str, used, s, level+1);
				str.deleteCharAt(str.length()-1);
				used[i]=false;
			}
		}
	}	
}
