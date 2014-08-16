package test.com.interview.math;

import org.junit.Assert;
import org.junit.Test;

import com.interview.algorithm.math.MathCommonQuetions;

public class TestMathCommonQuestions {
	@Test
	public void testBigIntegerAdd() {
		int[] int1 = {1,2,3,4,5};
		int[] int2 = {8,8,8,5,5};
		
		int[] results = {1,0,1,2,0,0};
		
		Assert.assertArrayEquals(results, MathCommonQuetions.bigIntegerAdd(int1, int2));
	}
}
