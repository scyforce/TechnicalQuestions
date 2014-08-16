package com.interview.leetcode;

import java.util.Stack;

/**

	Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
	
	
	Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
	
	
	The largest rectangle is shown in the shaded area, which has area = 10 unit.
	
	For example,
	Given height = [2,1,5,6,2,3],
	return 10.

 * @author shuchun.yang
 *
 */
public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		int[] height = {4,3,2,1};//{6,2,5,4,5,1,6};
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		System.out.println(l.largestRectangleArea(height));
	}
	
	public int largestRectangleArea(int[] height) {
        if (height==null||height.length==0) {
        	return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int max_area = 0;
        
        for (int i=0; i<height.length; i++) {        	
        	if (stack.isEmpty()) {
        		stack.push(i);
        	} else  {
        		//the idea is go through all elements in the array, the current element is the right index which is smaller than
        		//the top element in the stack, then pop the stack to find the element needs calculation, then the top element in 
        		//the stack is the left index, then use bar * (rightIndex - leftIndex - 1) to get the area and calculate the max area
        		while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
        			int top = stack.pop();
        			if (stack.empty()) {
        				max_area = Math.max(max_area, height[top] * i);
        			} else {
        				//i - stack.peek - (the current element itself so -1)
        				max_area = Math.max(max_area, height[top] * (i - stack.peek() - 1));
        			}
        		} 
        		//add all elements to compare
        		stack.push(i);
        	}
        }
        
        //calculate for the rest of the bar in stack
        while (!stack.isEmpty()) {
        	int top = stack.pop();
			if (stack.empty()) {
				max_area = Math.max(max_area, height[top] * height.length);
			} else {
				max_area = Math.max(max_area, height[top] * (height.length - stack.peek() - 1));
			}
        }
        
        return max_area;
    }
}
