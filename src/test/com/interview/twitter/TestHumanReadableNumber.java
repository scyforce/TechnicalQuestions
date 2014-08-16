package test.com.interview.twitter;

import org.junit.Assert;

import org.junit.Test;

import com.interview.company.twitter.HumanReadableNumber;

public class TestHumanReadableNumber {
	
	private void testHumanReadableNumber(int[] testNumbers, String[] expectedNumbers) {
		HumanReadableNumber number = new HumanReadableNumber();		
		int index = 0;
		for (int testNumber : testNumbers) {
			Assert.assertEquals(expectedNumbers[index], number.convert(testNumber));
			index = index + 1;
		}	
	}
	
	@Test
	public void testHumanReadableNumberLessThanZero() {
		int[] testNumbers = {-1,-10};
		String[] expectedNumbers = {"NegativeOne","NegativeTen"};
		
		testHumanReadableNumber(testNumbers, expectedNumbers);
	}
	
	@Test
	public void testHumanReadableNumberLessThanTen() {
		int[] testNumbers = {0,1,2,3,4,5,6,7,8,9};
		String[] expectedNumbers = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		
		testHumanReadableNumber(testNumbers, expectedNumbers);
	}
	
	
	@Test
	public void testHumanReadableNumberMoreThanNineAndLessThanTwenty() {
		int[] testNumbers = {10,11,12,13,14,15,16,17,18,19};
		String[] expectedNumbers = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		
		testHumanReadableNumber(testNumbers, expectedNumbers);
	}
	
	@Test
	public void testHumanReadableNumberMoreThanNineteenAndLessThanOneHundred() {
		int[] testNumbers = {20,30,40,50,60,70,80,90,91,95,99};
		String[] expectedNumbers = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "NinetyOne", "NinetyFive", "NinetyNine"};
		
		testHumanReadableNumber(testNumbers, expectedNumbers);
	}
	
	@Test
	public void testHumanReadableNumberMoreThanNinetyNineAndLessThanOneThousand() {
		int[] testNumbers = {100, 101, 121, 500, 999};
		String[] expectedNumbers = {"OneHundred","OneHundredOne","OneHundredTwentyOne","FiveHundred","NineHundredNinetyNine"};
		
		testHumanReadableNumber(testNumbers, expectedNumbers);
	}
	
	@Test
	public void testHumanReadableNumberMoreThanNineHundredNinetyNineAndLessThanOneBillion() {
		int[] testNumbers = {1000, 1001, 5199, 10250, 100250, 9999999};
		String[] expectedNumbers = {"OneThousand","OneThousandOne","FiveThousandOneHundredNinetyNine","TenThousandTwoHundredFifty","OneHundredThousandTwoHundredFifty","NineMillionNineHundredNinetyNineThousandNineHundredNinetyNine"};
		
		testHumanReadableNumber(testNumbers, expectedNumbers);
	}
}
