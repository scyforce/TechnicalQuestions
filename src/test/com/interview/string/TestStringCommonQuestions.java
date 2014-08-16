package test.com.interview.string;

import org.junit.Assert;
import org.junit.Test;

import com.interview.algorithm.string.StringCommonQuestions;
import com.interview.leetcode.LongestPalindromicSubstring;
import com.interview.leetcode.LongestSubstringWithoutRepeatingCharacters;

public class TestStringCommonQuestions {
	@Test
	public void testFindLongestPalindromString() {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		
		String str = "acdaba";
		String sub = "aba";
		Assert.assertEquals(sub, l.longestPalindrome(str));
		
		str = "acdababa";
		sub = "ababa";
		Assert.assertEquals(sub, l.longestPalindrome(str));
	}
	
	@Test
	public void testFindLongestNonRepeatedSubString() {
		String str = "abcabcd";
		String subStr = "abcd";
		
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		Assert.assertEquals(subStr.length(), l.lengthOfLongestSubstring(str));
		
		str = "aaaaaa";
		subStr = "a";
		Assert.assertEquals(subStr.length(), l.lengthOfLongestSubstring(str));
		
		str = "stackoverflow";
		subStr = "stackoverfl";
		Assert.assertEquals(subStr.length(), l.lengthOfLongestSubstring(str));
		
	}
	
    @Test
    public void testFindSubString() {
    	String str = "abcde";
    	String subStr = "bcd";
    	
    	Assert.assertEquals(true, StringCommonQuestions.findSubString(str, subStr));
    	
    	str = "cd";
    	subStr = "ef";
    	Assert.assertEquals(false, StringCommonQuestions.findSubString(str, subStr));
    	
    	
    	str = "abcde";
    	subStr = "abc";
    	Assert.assertEquals(true, StringCommonQuestions.findSubString(str, subStr));
    	
    	str = "abcde";
    	subStr = "cde";
    	Assert.assertEquals(true, StringCommonQuestions.findSubString(str, subStr));
    	
    	str = "abcde";
    	subStr = "cd";
    	Assert.assertEquals(true, StringCommonQuestions.findSubString(str, subStr));
    	
    	str = "abcabe";
    	subStr = "cab";
    	Assert.assertEquals(true, StringCommonQuestions.findSubString(str, subStr));
    	
    	str = "abcabe";
    	subStr = "abd";
    	Assert.assertEquals(false, StringCommonQuestions.findSubString(str, subStr));
    }
}
