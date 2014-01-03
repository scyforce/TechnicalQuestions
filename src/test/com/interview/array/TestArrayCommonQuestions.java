package test.com.interview.array;


import java.util.Arrays;


import junit.framework.Assert;


import org.junit.Test;

import com.interview.datastructure.array.ArrayCommonQuestions;

public class TestArrayCommonQuestions {
	@Test
	public void testFindPivotValue() {
		int[] array = new int[]{4,5,6,7,8,9,10,11,1,1,2,3};
        
        int pivotIndex = ArrayCommonQuestions.findPivot(array);
        Assert.assertEquals(7, pivotIndex);
        
        int[] array1 = new int[]{1,1,1,1,0};
        pivotIndex = ArrayCommonQuestions.findPivot(array1);
        Assert.assertEquals(3, pivotIndex);
	}
	
	@Test
	public void testSlideWindowMinium() {
		int[] array = {4, 3, 2, 1, 5, 7, 6, 8, 9};
		int[] results = {2, 1, 1, 1, 5, 6, 6};
		int num = 3;
		
		Assert.assertEquals(Arrays.toString(results), Arrays.toString(ArrayCommonQuestions.slideWindowMinimum(array, num)));
	}
	
	@Test
	public void testCanJump() {
		int[] array = {2,3,1,1,4};
		
		Assert.assertEquals(2, ArrayCommonQuestions.canJump(array, 0));
		
		int[] array1 = {2, 6, 1, 15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		Assert.assertEquals(3, ArrayCommonQuestions.canJump(array1, 0));
	}
	
	@Test
	public void testFindElementInRotatedArray() {
		int[] array = {4,5,6,7,0,1,2,3};
		
		Assert.assertEquals(2, ArrayCommonQuestions.findElementInRotatedArray(array, 6));
		Assert.assertEquals(5, ArrayCommonQuestions.findElementInRotatedArray(array, 1));
		Assert.assertEquals(-1, ArrayCommonQuestions.findElementInRotatedArray(array, 10));
	}
	
	@Test
	public void testFindKComplementary() {
		int[] array = {2,4,3,1,5,7,6,9};
		int sum = 13;
		
		Assert.assertEquals(2, ArrayCommonQuestions.findKComplementary(array, sum));
		
		int[] array1 = {2,4,3,1,5,7,6,9};
		sum = 9;
		Assert.assertEquals(3, ArrayCommonQuestions.findKComplementary(array1, sum));
	}
	
    @Test
    public void testFindCommonElementInArray() {
    	int[] array1 = {3,5,1,10,22,45,33,56,7,19,0,19};
    	int[] array2 = {350,5,22,33,56,8,10,100,233,19};
    	
    	int[] expectedCommon = {5,22,33,56,10,19};
    	int[] common = ArrayCommonQuestions.findCommonElementInArray(array1, array2);
    	int index = 0;
    	for (int expected : expectedCommon) {
    		Assert.assertEquals(expected, common[index++]);
    	}    	
    }
	
	
	@Test
	public void testFindFirstNonRepeatedChar() {
		String testStr = "abcadebg";
		Assert.assertEquals('c', ArrayCommonQuestions.findFirstNonRepeatedChar(testStr));
		
		testStr = "ababab";
		Assert.assertEquals('\u0000', ArrayCommonQuestions.findFirstNonRepeatedChar(testStr));
	}
	
	@Test
	public void testStr2Int() {
		String testStr = "100";
		Assert.assertEquals(100, ArrayCommonQuestions.str2int(testStr));
		
		testStr = "324";
		Assert.assertEquals(324, ArrayCommonQuestions.str2int(testStr));
		
		testStr = "-100";
		Assert.assertEquals(-100, ArrayCommonQuestions.str2int(testStr));
		
		testStr = "0";
		Assert.assertEquals(0, ArrayCommonQuestions.str2int(testStr));
	}
	
	@Test
	public void testInt2Str() {
		int testNumber = 100;
		Assert.assertEquals("100", ArrayCommonQuestions.int2str(testNumber));
		
		testNumber = 324;
		Assert.assertEquals("324", ArrayCommonQuestions.int2str(testNumber));
		
		testNumber = -100;
		Assert.assertEquals("-100", ArrayCommonQuestions.int2str(testNumber));
		
		testNumber = 0;
		Assert.assertEquals("0", ArrayCommonQuestions.int2str(testNumber));
	}
	
	@Test
	public void testReverse_rec () {
    	String orginalStr = "nihao ta shi shui";
    	String expectedStr = "iuhs ihs at oahin";
    	
    	Assert.assertEquals(expectedStr, ArrayCommonQuestions.reverse_rec(orginalStr));
    }
    
    @Test
	public void testReverse () {
    	String orginalStr = "nihao ta shi shui";
    	String expectedStr = "iuhs ihs at oahin";
    	
    	Assert.assertEquals(expectedStr, ArrayCommonQuestions.reverse(orginalStr));
    }
    
    @Test
    public void testx2() {
    	int number = 5;
    	System.out.println(ArrayCommonQuestions.x2(number));
    	Assert.assertEquals(32, ArrayCommonQuestions.x2(number));
    }
}
