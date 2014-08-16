package test.com.interview.evernote;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.interview.company.evernote.highestfour.HighestFour;

//Test class
public class TestEvernoteChallenge {
	
	@Test
	public void testFindHighestFourElementsInArray() {
		HighestFour test = new HighestFour();

		int[] array1 = {2,5,6,1,10,3,8,11,3,9,2};
		int[] expected1 = {8,9,10,11};		
		int[] actual1 = test.findHighestFourElementsInArray(array1);
		Arrays.sort(actual1);		
		Assert.assertTrue(Arrays.equals(expected1, actual1));
		
		int[] array2 = {1,2,3,4,5,6,7};
		int[] expected2 = {4,5,6,7};		
		int[] actual2 = test.findHighestFourElementsInArray(array2);
		Arrays.sort(actual2);
		Assert.assertTrue(Arrays.equals(expected2, actual2));
		
		int[] array3 = {1,2};
		int[] expected3 = null;	
		int[] actual3 = test.findHighestFourElementsInArray(array3);
		Assert.assertEquals(expected3, actual3);	
		
		int[] array4 = {4,5,2,4,5,6,7};
		int[] expected4 = {5,5,6,7};		
		int[] actual4 = test.findHighestFourElementsInArray(array4);
		Arrays.sort(actual4);
		Assert.assertTrue(Arrays.equals(expected4, actual4));
		
		int[] array5 = {4,2,1,3};
        int[] expected5 = {1,2,3,4};        
        int[] actual5 = test.findHighestFourElementsInArray(array5);
        Arrays.sort(actual5);
        Assert.assertTrue(Arrays.equals(expected5, actual5));
	}
}
