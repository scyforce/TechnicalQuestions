package com.interview.leetcode;

/**

	Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
	
	For example,
	Given:
	s1 = "aabcc",
	s2 = "dbbca",
	
	When s3 = "aadbbcbcac", return true.
	When s3 = "aadbbbaccc", return false.

 * @author shuchun.yang
 *
 */
public class InterleavingString {
	public static void main(String[] args) {
		InterleavingString i = new InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(i.isInterleave(s1, s2, s3));
		
		s3 = "aadbbbaccc";
		System.out.println(i.isInterleave(s1, s2, s3));
		
		s1 = "a";
		s2 ="";
		s3 = "a";
		System.out.println(i.isInterleave(s1, s2, s3));
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null||s2==null||s3==null||s1.length()+s2.length()!=s3.length()) {
        	return false;
        }
		
        boolean[][] matched = new boolean[s1.length()+1][s2.length()+1];
        matched[0][0] = true;
        //s1 = aab s2=aac s3 = aaabac
        for (int i=1; i<=s1.length(); i++) {
        	if (s1.charAt(i-1)==s3.charAt(i-1)) {
        		matched[i][0] = true;
        	} else {
        		break;
        	}
        }
        
        for (int j=1; j<=s2.length(); j++) {
        	if (s2.charAt(j-1)==s3.charAt(j-1)) {
        		matched[0][j] = true;
        	} else {
        		break;
        	}
        }
        
        for (int i=1; i<=s1.length(); i++) {
        	char i1 = s1.charAt(i-1);
        	for (int j=1; j<=s2.length(); j++) {
        		int k = i+j;
        		char i3 = s3.charAt(k-1);
        		char i2 = s2.charAt(j-1);
        		
        		matched[i][j] = (i1==i3&&matched[i-1][j]) || (i2==i3&&matched[i][j-1]);
        		
        	}
        }
        
        //动态规划矩阵matched[l1][l2]表示s1取l1长度（最后一个字母的pos是l1-1)，s2取l2长度(最后一个字母的pos是l2-1)，是否能匹配s3的l1+12长度。
		//matched[l1][l2] = s1[l1-1] == s3[l1+l2-1] && matched[l1-1][l2] || s2[l2 - 1] == s3[l1+l2-1] && matched[l1][l2-1]
		
        return matched[s1.length()][s2.length()];
    }
}
