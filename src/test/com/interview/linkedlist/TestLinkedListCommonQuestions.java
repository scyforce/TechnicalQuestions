package test.com.interview.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.interview.algorithm.linkedlist.LinkedListCommonQuestions;
import com.interview.algorithm.linkedlist.Node;
import com.interview.algorithm.util.LinkedListUtils;

public class TestLinkedListCommonQuestions {	
	private static String[] elements = {"1","2","3","4","5"};
	
	
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
}
