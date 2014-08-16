package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	
	For example:
	Given "25525511135",
	
	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 * @author shuchun.yang
 *
 */
public class RestoreIPAddresses {
	public static void main(String[] args) {
		String s = "0000";
		RestoreIPAddresses r = new RestoreIPAddresses();
		ArrayList<String> results = r.restoreIpAddresses(s);
		System.out.println(Arrays.toString(results.toArray()));
	}
	
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> results = new ArrayList<String>();
		String[] curr = new String[4];
		restore(s, 0, curr, results);
		return results;
	}

	private void restore(String s, int level, String[] curr, ArrayList<String> result) {
		if (level == 4) {
			//if s is not empty, don't add.
			if (s.isEmpty()) {
				result.add(convertToIpString(curr));
			}
			return;
		}
		//if s is not empty
		if (!s.isEmpty()) {
			for (int i = 1; i<Math.min(4, s.length()+1); i++) {
				String left = s.substring(0, i);
				String right = s.substring(i);
				if (isValid(left)) {
					curr[level] = left;
					restore(right, level + 1, curr, result);
				}
			}
		}

	}

	private String convertToIpString(String[] curr) {
		StringBuilder sb = new StringBuilder();
		for (String s : curr) {
			sb.append(s);
			sb.append(".");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return s.equals("0");
		}
		int num = Integer.parseInt(s);
		return num <= 255 && num >= 0;
	}
}
