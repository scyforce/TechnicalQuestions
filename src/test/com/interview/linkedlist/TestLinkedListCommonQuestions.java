package test.com.interview.linkedlist;

import junit.framework.Assert;

import org.junit.Test;

import com.interview.datastructure.linkedlist.LinkedListCommonQuestions;
import com.interview.datastructure.linkedlist.Node;
import com.interview.datastructure.util.LinkedListUtils;

public class TestLinkedListCommonQuestions {	
	private static String[] elements = {"1","2","3","4","5"};
	
	@Test
	public void testRotateLinkedList() {
		Node<String> head = LinkedListUtils.createLinkedList(elements);
		Node<String> newHead = LinkedListCommonQuestions.rotateRight(head, 2);
		LinkedListUtils.printLinkedList(newHead);		
		Assert.assertEquals("4", newHead.getValue());
	}
	
	
	@Test
	public void testFindMiddleNode() {
		Node<String> head = LinkedListUtils.createLinkedList(elements);
		Assert.assertEquals("3", LinkedListCommonQuestions.findMiddleNode(head).getValue());
	}
	
	@Test
	public void testFindMthNodeToLastNode() {
		Node<String> head = LinkedListUtils.createLinkedList(elements);
		LinkedListUtils.printLinkedList(head);
		Assert.assertEquals("4", LinkedListCommonQuestions.findMthNodeToLastNode(head, 1).getValue());
		Assert.assertEquals("3", LinkedListCommonQuestions.findMthNodeToLastNode(head, 2).getValue());
	}
	
	@Test
    public void testIsCyclicLinkedList () {
        Node<String> head = LinkedListUtils.createLinkedList(elements);		
		Assert.assertFalse(LinkedListCommonQuestions.isCyclicLinkedList(head));
		
		head = LinkedListUtils.createCyclicLinkedList();
		Assert.assertTrue(LinkedListCommonQuestions.isCyclicLinkedList(head));
    }
    
    @Test
    public void testReverseLinkedList() {
    	Node<String> node1 = new Node<String>("1");
    	Node<String> node2 = new Node<String>("2");
    	Node<String> node3 = new Node<String>("3");
    	Node<String> node4 = new Node<String>("4");
    	
    	node1.setNext(node2);
    	node2.setNext(node3);
    	node3.setNext(node4);
    	
    	LinkedListCommonQuestions.reverseLinkedList(node1);
        
    	Assert.assertEquals(null, node1.getNext());
    	Assert.assertEquals(node1, node2.getNext());
    	Assert.assertEquals(node2, node3.getNext());
    	Assert.assertEquals(node3, node4.getNext());   	
    }
}
