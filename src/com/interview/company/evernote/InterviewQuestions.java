package com.interview.company.evernote;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.interview.algorithm.linkedlist.Node;
import com.interview.algorithm.util.LinkedListUtils;

public class InterviewQuestions {
	
	public static int sumOfLinkedList(Node<Integer> head) {
		if (head == null) {
			return -1;
		}
		
		int sum = 0;
		while (head.getNext()!=null) {
			sum += head.getValue();
		}
		
		return sum;
	}
	
	/*
	 * This is to check if you have considered all cases
	 * 1. insert in a regular position
	 * 2. head is null
	 * 3. insert in the first position
	 * 4. the position you insert is out of list length
	 */
	public static Node<Integer> insertNodeToLinkedList(Node<Integer> head, int value, int position) {
		if (position<=0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if (head==null) {
			if (position==1) {
				head = new Node<Integer>(value);
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}
		} else {
			Node<Integer> newNode = new Node<Integer>(value);
			if (position==1) {
				newNode.setNext(head);
				head = newNode;
			} else {
				Node<Integer> tempHead = head;
				while (position-2>0) {
					tempHead = tempHead.getNext();
					position--;
				}				
				if (tempHead==null) {
					throw new ArrayIndexOutOfBoundsException();
				} else {
					Node<Integer> oldNext = tempHead.getNext();
					newNode.setNext(oldNext);
					tempHead.setNext(newNode);			
				}
			}			
		}
		return head;
	}
	
	public static int[] mergeTwoSortedArrayWithoutDupe(int[] array1, int[] array2) {
		
		int[] results = new int[array1.length+array2.length];
		int index1 = 0, index2 = 0, index = 0;
		
		while (index1<array1.length && index2<array2.length) {
			if (array1[index1]<array2[index2]) {
				if (index==0 || (index>0 && array1[index1]!=results[index-1])) {
					results[index] = array1[index1];
					index++;
				}				
				index1++;
				
			} else {
				if (index==0 || (index>0 && array2[index2]!=results[index-1])) {
					results[index] = array2[index2];
					index++;
				} 
				index2++;
			}
		}
		
	    while (index1<array1.length) {
	    	if (index>0 && results[index-1]!=array1[index1]) {
		    	results[index++] = array1[index1];
	    	}
	    	index1++;
	    }
	    
	    while (index2<array2.length) {
	    	if (index>0 && results[index-1]!=array2[index2]) {
		    	results[index++] = array2[index2];
	    	}
	    	index2++;
	    }
				
		return results;
		
	}
	
	public static int[] unionOfTwoSets(int[] array1, int[] array2) {
		Map<Integer, Boolean> arrayMap = new HashMap<Integer, Boolean>();
		for (int element : array1) {
			arrayMap.put(element, true);
		}
		for (int element : array2) {
			arrayMap.put(element, true);
		}
		
		int[] results = new int[arrayMap.size()];
		int index = 0;
		for (int element : arrayMap.keySet()) {
			results[index++] = element; 
		}
		
		return results;
	}
	
	public static void removeDuplicate(int[] array) {
		int count = 1;
		int previous = array[0];
		for (int i=1; i<array.length; i++) {
			if (array[i]!=previous) {
				array[count] = array[i];
				count = count + 1;
			}
			previous = array[i];
		}	
	}
	
	public static int[] removeDuplicates(int[] array) {
		// if array is null or empty, return itself back
		if (array == null || array.length == 0) {
			return array;
		}

		// the results container
		int[] results = new int[array.length];

		// set previous to the first element in array
		int previous = array[0];
		// put first element in the results array
		results[0] = previous;
		int index = 1;
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			// since it is sorted, keep comparing the current with the previous
			// element, if not equal, add it to the results array
			// and set previous value to current
			if (current != previous) {
				results[index] = current;
				previous = current;
				index++;
			}
		}
		return results;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(InterviewQuestions.getSqureRoot(2, 0.0000001));
		Integer[] array = {1};
		
		Node<Integer> head = LinkedListUtils.createLinkedList(array);
		
		Node<Integer> newHead = InterviewQuestions.insertNodeToLinkedList(head, 7, 1);
		
		LinkedListUtils.printLinkedList(newHead);
		
	    /*int[] array1 = {};
	    System.out.println(Arrays.toString(InterviewQuestions.removeDuplicates(array1)));
	    
	    int[] array2 = {1};
	    System.out.println(Arrays.toString(InterviewQuestions.removeDuplicates(array2)));
	    
	    int[] array3 = {1,2};
	    System.out.println(Arrays.toString(InterviewQuestions.removeDuplicates(array3)));*/
	    
	    int[] array4 = {1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17};
	    InterviewQuestions.removeDuplicate(array4);
	    System.out.println(Arrays.toString(array4));
	}

}
