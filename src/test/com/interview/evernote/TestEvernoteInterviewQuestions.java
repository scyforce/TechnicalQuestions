package test.com.interview.evernote;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.interview.company.evernote.InterviewQuestions;

public class TestEvernoteInterviewQuestions {
	
	@Test
	public void testMergeTwoSortedArrayWithoutDupe() {
		int[] array1 = {2,3,5,6,7,8};
		int[] array2 = {1,2,3,4,5};
		int[] expected = {1,2,3,4,5,6,7,8,0,0,0};
		
		int[] actual = InterviewQuestions.mergeTwoSortedArrayWithoutDupe(array1, array2);
		
		Assert.assertTrue(Arrays.equals(expected, actual));
		
		int[] array11 = {0,1,1,2,3,3,5,5};
		int[] array22 = {1,2,3,4,5};
		int[] expected1 = {0,1,2,3,4,5,0,0,0,0,0,0,0};
		
		int[] actual1 = InterviewQuestions.mergeTwoSortedArrayWithoutDupe(array11, array22);
		
		Assert.assertTrue(Arrays.equals(expected1, actual1));
	}
	
	@Test
	public void testUnionOfTwoSets() {
		int[] array1 = {2,3,5,6,7,8};
		int[] array2 = {1,2,3,4,5};
		int[] expected = {1,2,3,4,5,6,7,8};
		
		int[] actual = InterviewQuestions.unionOfTwoSets(array1, array2);
		Arrays.sort(actual);
		
		Assert.assertTrue(Arrays.equals(expected, actual));
	}
}
