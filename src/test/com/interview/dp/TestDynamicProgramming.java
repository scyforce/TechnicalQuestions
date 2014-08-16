package test.com.interview.dp;

import org.junit.Assert;
import org.junit.Test;

import com.interview.algorithm.dp.DynamicProgramming;

public class TestDynamicProgramming {
	@Test
	public void testLongestIncreasingSubsequence() {
		int[] array = {0,3,2,4,6,1};
		Assert.assertEquals(4, DynamicProgramming.findLongestIncreasingSubsequence(array));
		
		int[] array1 = {0,3,2,4,1};
		Assert.assertEquals(3, DynamicProgramming.findLongestIncreasingSubsequence(array1));
	}
}
