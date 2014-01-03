package com.interview.datastructure.util;

import com.interview.datastructure.linkedlist.Node;


public class LinkedListUtils {   
	public static <T> Node<T> createLinkedList(T[] array) {
		Node<T> previous = null;
		Node<T> head = null;
		for (T elem : array) {
			Node<T> next = new Node<T>(elem);
			if (previous != null) {
				previous.setNext(next);
			} else {
				head = next;
			}
			previous = next;
		}
		return head;
	}
	
	
	public static <T> void printLinkedList(Node<T> head) {
    	while (head!=null) {
    		System.out.print(head.getValue());
    		head = head.getNext();
    		if (head!=null) {
    			System.out.print("->");
    		}
    	}
    	System.out.println();
    }
	
	public static Node<String> createLinkedList() {
		Node<String> head = null,node2=null, node3=null, node4=null, node5 = null;		
		node5 = new Node<String>("5");		
		node4 = new Node<String>("4");
		node3 = new Node<String>("3");
		node2 = new Node<String>("2");
		head = new Node<String>("1");
			
		head.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		return head;
	}
	
	public static Node<String> createCyclicLinkedList() {
		Node<String> head = null,node2=null, node3=null;	
		node3 = new Node<String>("3");
		node2 = new Node<String>("2");
		head = new Node<String>("1");
		head.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node2);
		return head;
	}
}
