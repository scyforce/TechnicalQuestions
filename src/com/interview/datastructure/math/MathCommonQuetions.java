package com.interview.datastructure.math;

import java.util.Arrays;

public class MathCommonQuetions {
    public static int fibnacci_M(int i) {
    	if (i<=2) {
    		return 1;
    	} else {
    		int[] value = {1,1};
    		int sum = 0;
    		while (i>2) {
    			sum = value[0] + value[1];
    			value[1] = value[0];
    			value[0] = sum;
    			i--;
    		}
    		return sum;
    	}
    }
    
    public static int[] bigIntegerAdd(int[] int1, int[] int2) {
        int maxLength = Math.max(int1.length, int2.length) + 1;
        int[] results = new int[maxLength];
        
        int carryOn = 0;
        int j = results.length-1;
        for (int i=maxLength-2; i>=0; i--) {
        	int value1 = (i<int1.length) ? int1[i] : 0;
        	int value2 = (i<int2.length) ? int2[i] : 0;
        	
        	int sum = value1+value2+carryOn;
        	if (sum>=10) {
        		carryOn = 1;
        	} else {
        		carryOn = 0;
        	}
        	results[j--] = sum%10;
        }
        if (carryOn>0) {
        	results[j] = 1;
        }
        
    	System.out.println(Arrays.toString(results));
    	
    	return results;
    }
   
    
    public static void main(String[] args) {
    	//System.out.println(MathCommonQuetions.fibnacci_M(20));
    }
}
