package com.interview.leetcode;

/**

	Divide two integers without using multiplication, division and mod operator.	
	
	http://tianrunhe.wordpress.com/2012/07/14/division-without-using-or-divide-two-integers/
	
	The idea is log(a/b) = loga - logb
	so a/b = exp(loga-logb);
 * @author shuchun.yang
 *
 */
public class DivideTwoIntegers {
	public static void main(String[] args) {
		int dividend = Integer.MAX_VALUE;
		int divisor = 2;
		
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(dividend, divisor));
		
		System.out.println(dividend/divisor);
	}
	
	public int divideNaive(int dividend, int divisor) {
        int result = 0;
        while (dividend>0) {
        	result++;
        	dividend -= divisor;       	
        }
        return result;
    }
	
	public int divide(int dividend, int divisor) {
		if(divisor==0) {
			return 0;
		}		
		if(divisor==1) {
			return dividend;
		}		
		if (dividend==divisor) {
			return 1;
		}
		if (divisor==2) {
			return dividend>>1;
		}
	          		
		int result = 0;  
	    if(dividend==Integer.MIN_VALUE) {  
	    	result = 1;  
	        dividend += Math.abs(divisor);  
	    }  
	    
	    if(divisor==Integer.MIN_VALUE) {
	    	return result;  
	    }
	        		
		boolean isNegative = false;
		if (dividend>0&&divisor<0 || dividend<0&&divisor>0) {
			isNegative = true;
		}
		
		//if dividend==MIN_VALUE, abs will still show negative
		long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);

		while (a>=b) {
			long temp = b;			
			for (int i=1; a>=temp; i<<=1, temp<<=1) {
				a-=temp;
				result+=i;
			}			
		}
		
		/**
		 * dividend = Math.abs(dividend);
		   divisor = Math.abs(divisor);

		   result += (int) Math.floor(Math.pow(Math.E, Math.log(dividend) - Math.log(divisor)));
		 */
		
		return (isNegative?-result:result);
	}
}
