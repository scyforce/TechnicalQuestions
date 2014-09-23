package com.interview.company.linkedin;

import java.util.ArrayList;
import java.util.List;

public class SumOfNestedIntegers {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		List<Object> list1 = new ArrayList<Object>();
		list1.add(2);
		list1.add(2);
		
		List<Object> list2 = new ArrayList<Object>();
		list2.add(2);
		list2.add(2);
		
		list1.add(list2);
		
		list.add(1);			
		list.add(1);	
		list.add(list1);
		
		SumOfNestedIntegers s = new SumOfNestedIntegers();
		System.out.println(s.sumOfNestedIntegers(list));
	}
	
	
	public int sumOfNestedIntegers(List<Object> list) {
		return sumOfNestedIntegers(list, 1, 0);
	}
	
	public int sumOfNestedIntegers(List<Object> list, int level, int sum) {		
		for (Object o : list) {
			if (o instanceof Integer) {
				sum = sum + ((Integer)o).intValue()*level;
			} else if (o instanceof List){
				sum = sumOfNestedIntegers((List<Object>)o, level+1, sum);
			}
		}
		
		return sum;
	}
}
