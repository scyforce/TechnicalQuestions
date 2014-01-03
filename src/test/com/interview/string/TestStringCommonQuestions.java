package test.com.interview.string;

import junit.framework.Assert;

import org.junit.Test;

import com.interview.datastructure.string.StringCommonQuestions;

public class TestStringCommonQuestions {
	@Test
	public void testFindLongestPalindromString() {
		String str = "acdaba";
		Assert.assertEquals(3, StringCommonQuestions.findLongestPalindromString1(str));
		
		String str1 = "acdababa";
		Assert.assertEquals(5, StringCommonQuestions.findLongestPalindromString1(str1));
	}
	
	@Test
	public void testFindLongestNonRepeatedSubString() {
		String str = "abcabcd";
		String subStr = "abcd";
		
		Assert.assertEquals(subStr, StringCommonQuestions.findLongestNonRepeatedSubString(str));
		
		str = "aaaaaa";
		subStr = "a";
		Assert.assertEquals(subStr, StringCommonQuestions.findLongestNonRepeatedSubString(str));
		
		str = "stackoverflow";
		subStr = "stackoverfl";
		Assert.assertEquals(subStr, StringCommonQuestions.findLongestNonRepeatedSubString(str));
		
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
