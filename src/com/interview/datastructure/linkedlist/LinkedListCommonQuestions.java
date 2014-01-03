package com.interview.datastructure.linkedlist;

public class LinkedListCommonQuestions {	
	//rotate the linked list by the specified number
	//1->2->3->4->5 by 2 , 4->5->1->2->3
	public static <T> Node<T> rotateRight(Node<T> head, int n) {
		Node<T> kHead = head;
        while (n>0) {
            kHead = kHead.getNext();
            n--;
        }
        Node<T> newHead = kHead.getNext();
        Node<T> jHead = kHead;
        while(jHead.getNext()!=null) {
            jHead = jHead.getNext();
        }       
        jHead.setNext(head);       
        kHead.setNext(null);
        return newHead;
    }
	
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
    
    public static <T> void reverseLinkedList(Node<T> head) {
    	Node<T> previous = null;
    	Node<T> temp = null;
    	while (head!=null) {    		
    		temp = head.getNext();
    		head.setNext(previous);
    		previous = head;
    		head = temp;
    	} 	
    }
	
    public static<T> Node<T> findStartOfLoopInCyclicLinkedList(Node<T> node) {
    	if (node == null) {
    		return null;
    	}
    	
    	Node<T> node1 = node;
    	Node<T> node2 = node;
    	
    	while (node2.getNext() != null) {
    		node1 = node1.getNext();
    		node2 = node2.getNext().getNext();
    		if (node1 == node2) {
    			break;
    		}
    	}
    	
    	//no loop
    	if (node2.getNext()==null) {
    		return null;
    	}
    	
    	node1 = node;
    	while (node1 != node2) {
    		node1 = node1.getNext();
    		node2 = node2.getNext();
    	}
    	return node2;
    }
    
	public static <T> boolean isCyclicLinkedList(Node<T> node) {
		if (node == null) {
			return false;
		}
		
		Node<T> turtle = node;//slow node
		Node<T> rabbit = node;//faster node
		
		while (rabbit.getNext() != null) {
			turtle = turtle.getNext();
	        rabbit = rabbit.getNext().getNext();
			//if two nodes meets, there is a cyclic
			if (rabbit.equals(turtle)) {
				System.out.println("Turtle and Rabbit meet");
				return true;
			} else if (rabbit.getNext()==null) {
				System.out.println("Rabbit reaches END");
				//end of the linked list
				return false;
			} 					    
		}
		return false;
	}
}
