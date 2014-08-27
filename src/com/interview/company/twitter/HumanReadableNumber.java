package com.interview.company.twitter;

public class HumanReadableNumber {
	public static final String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	public static final String[] teens ={ "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	public static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	public static final String[] thousandsGroups = { "", "Thousand", "Million", "Billion" };
	
    private String convertToLessThanOneThousand(int number) {
    	if (number==0) {
    		return "";
    	}else if (number<10) {
    		return ones[number]; 
    	} else if (number<20) {
    		return teens[number%10];
    	} else if (number<100) {
    		return tens[number/10] + ones[number%10];
    	} else if (number<1000) {
    		return ones[number/100] + "Hundred" + convertToLessThanOneThousand(number%100);
    	} else {
    		throw new UnsupportedOperationException("This is meant to call for number less than 1000");
    	}
    }
    
    private String convertToMoreThanOneThousand(int number) {
    	if (number<1000) {
    		throw new UnsupportedOperationException("This is meant to call for number more than 1000");
    	}
    	
    	int thousands = 0;
    	int leftPartNumber = number;
    	int thousandsNumber = 1;
    	while (leftPartNumber>=1000) {
    		leftPartNumber/=1000;
    		thousands+=1;
    		thousandsNumber*=1000;
    	}
    	//10,0001
        int rightPartNumber = number%thousandsNumber;  	
    	return convertToLessThanOneThousand(leftPartNumber) + thousandsGroups[thousands] + (rightPartNumber>1000 ? convertToMoreThanOneThousand(rightPartNumber) : convertToLessThanOneThousand(rightPartNumber));
    }
    
    public String convert(int number) {
    	if (number==0) {
    		return "Zero";
    	} else if (number<0) {
    		return "Negative" + convert(-number);
    	} else {
    		if (number<1000) {
    			return convertToLessThanOneThousand(number);
    		} else {
    			return convertToMoreThanOneThousand(number);  			   			
    		}
    	}  	
    }
    
    public static void main(String[] args) {
    	HumanReadableNumber h = new HumanReadableNumber();
    	System.out.println(h.convert(10100250));
    }
}
