package test.com.interview.search;

import org.junit.Test;

import com.interview.algorithm.search.BinarySearch;

import org.junit.Assert;

public class TestBinarySearch {
	@Test
	public void testBinarySearch() {
		int[] arrays = {1,2,3,4,5,8,10,122,500};
		Assert.assertEquals(4, BinarySearch.binarySearch(arrays, 5, 0, arrays.length-1));
		Assert.assertEquals(7, BinarySearch.binarySearch(arrays, 122, 0, arrays.length-1));
		Assert.assertEquals(-2, BinarySearch.binarySearch(arrays, 7, 0, arrays.length-1));
		Assert.assertEquals(2, BinarySearch.binarySearch(arrays, 3, 0, arrays.length-1));
		
		int[] unorderedArrays = {1,322,3,10,15,28,100,323,300};
		
		Assert.assertEquals(-3, BinarySearch.binarySearch(unorderedArrays, 125, 0, arrays.length-1));
		Assert.assertEquals(-3, BinarySearch.binarySearch(unorderedArrays, 322, 0, arrays.length-1));
	}
}
