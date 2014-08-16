package com.interview.leetcode;

import java.util.Stack;

/**

	Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

 * @author shuchun.yang
 *
 */
public class MaximalRectangle {
	public static void main(String[] args) {
		/*char[][] matrix = {
			{'0','1','1'},{'1','1','1'},{'0','1','1'},{'0','1','1'}
		};*/
		
		char[][] matrix = {{'0', '0', '0'},{'0', '0', '0'},{'0', '0', '0'},{'0', '0', '0'}};
		
		MaximalRectangle m = new MaximalRectangle();
		System.out.println(m.maximalRectangle(matrix));
	}
	
	public int maximalRectangle(char[][] matrix) {
		if (matrix==null||matrix.length==0) {
			return 0;
		}
		
		int row = matrix.length;
		int column = matrix[0].length;
		
		int max_area = 0;
		int[][] heights = new int[row][column];
		//calculate the histogram for each row matrix[i][j]
		for (int j=0; j<column; j++) {
			for (int i=0; i<row; i++) {
				if (matrix[i][j]-'0'==0) {
					heights[i][j] = 0;
				} else {
					if (i==0) {
						heights[i][j] = 1;
					} else {
						heights[i][j] = heights[i-1][j] + 1;
					}
				}
			}
		}
        
        Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<heights.length; i++) {	
	        //use the same method in largestRectangleInHistogram.java
			for (int j=0; j<heights[i].length; j++) {        	
	        	if (stack.isEmpty()) {
	        		stack.push(j);
	        	} else  {
	        		//the idea is go through all elements in the array, the current element is the right index which is smaller than
	        		//the top element in the stack, then pop the stack to find the element needs calculation, then the top element in 
	        		//the stack is the left index, then use bar * (rightIndex - leftIndex - 1) to get the area and calculate the max area
	        		while (!stack.isEmpty() && heights[i][stack.peek()] > heights[i][j]) {
	        			int top = stack.pop();
	        			if (stack.empty()) {
	        				max_area = Math.max(max_area, heights[i][top] * j);
	        			} else {
	        				//i - stack.peek - (the current element itself so -1)
	        				max_area = Math.max(max_area, heights[i][top] * (j - stack.peek() - 1));
	        			}
	        		} 
	        		//add all elements to compare
	        		stack.push(j);
	        	}
	        }
	        
	        //calculate for the rest of the bar in stack
	        while (!stack.isEmpty()) {
	        	int top = stack.pop();
				if (stack.empty()) {
					max_area = Math.max(max_area, heights[i][top] * heights[i].length);
				} else {
					max_area = Math.max(max_area, heights[i][top] * (heights[i].length - stack.peek() - 1));
				}
	        }
		}
		return max_area;
    }
}
