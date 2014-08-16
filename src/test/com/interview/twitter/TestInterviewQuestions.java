package test.com.interview.twitter;

import org.junit.Assert;
import org.junit.Test;

import com.interview.company.twitter.InterviewQuestions;

public class TestInterviewQuestions {
	
	@Test
	public void testBigIntegerAdd() {
    	String int1 = "9999";
    	String int2 = "99";
    	
    	Assert.assertEquals(9999+99+"", InterviewQuestions.bigIntegerAdd(int1, int2));
    	
    	int1 = "1234567";
    	int2 = "1234567";
    	
    	Assert.assertEquals(1234567+1234567+"", InterviewQuestions.bigIntegerAdd(int1, int2));
	}
	
	@Test
	public void testDoesParentheseMatch() {
		String[] strs = new String[]{"()",")(","(abcd(e)","(a)(b)"};
		boolean[] expected = new boolean[]{true,false,false,true};
		
		for (int i=0; i<strs.length; i++) {
			Assert.assertEquals(expected[i], InterviewQuestions.doesParenthesesMatch(strs[i], 0, 0));
		}
	}
}
