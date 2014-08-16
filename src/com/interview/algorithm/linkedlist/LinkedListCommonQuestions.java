package com.interview.algorithm.linkedlist;

public class LinkedListCommonQuestions {		
	public static <T> Node<T> findMiddleNode(Node<T> node) {
		if (node==null) {
			return null;
		}
		
		Node<T> fast = node;
		
		while (fast!=null && fast.getNext()!=null) {		
			node = node.getNext();
			fast = fast.getNext().getNext();		
		}
		return node;
	}
	
	//find the last second node to last node 
	public static <T> Node<T> findMthNodeToLastNode(Node<T> node, int index) {
		Node<T> head = node;
		Node<T> current = node;
		
		for (int i=0; i<index; i++) {
			current = current.getNext();
		}
		
		while (current.getNext()!=null) {
			System.out.println(head.getValue() + " " + current.getValue());
			head = head.getNext();
			current = current.getNext();		
		}
		
		return head;		
	}
}
