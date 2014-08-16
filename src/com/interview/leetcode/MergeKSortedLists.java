package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**

	Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 * @author shuchun.yang
 *
 */
public class MergeKSortedLists {
	public static void main(String[] args) {
		/*ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(12);
		l1.next = l2; l2.next = l3;
		
		ListNode t1 = new ListNode(4);
		ListNode t2 = new ListNode(7);
		ListNode t3 = new ListNode(14);
		ListNode t4 = new ListNode(15);
		t1.next = t2; t2.next = t3; t3.next = t4;
		
		ListNode n1 = new ListNode(1);*/
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		//lists.add(l1);
		//lists.add(t1);
		//lists.add(n1);
		lists.add(null);
		
		MergeKSortedLists m = new MergeKSortedLists();
		ListNode result = m.mergeKLists(lists);
		result.print();		
	}
	
	
	public ListNode mergeKLists1(ArrayList<ListNode> lists) {
		if (lists==null||lists.isEmpty()) {
			return null;
		}
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		
		for (ListNode list : lists) {
			if (list!=null) {
				minHeap.offer(list);
			}			
		}
		
		ListNode previous = new ListNode(0);
		ListNode head = previous;
		
		while (!minHeap.isEmpty()) {
			ListNode minNode = minHeap.poll();
			head.next = minNode;
			if (minNode.next!=null) {
				minHeap.offer(minNode.next);
			}
			head = head.next;
		}
		
		return previous.next;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Time complexity: O(nklogk), Space complexity: O(k)
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists==null||lists.size()==0) {
			return null;
		}
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		
		for (ListNode node : lists) {
			//node maybe null
			if (node!=null) {
				minHeap.offer(node);
			}			
		}
		
		ListNode previous = new ListNode(0);
	    ListNode head = previous;
		//process other nodes
		while (!minHeap.isEmpty()) {
			ListNode minNode = minHeap.poll();
			head.next = minNode; 	
			if (minNode.next!=null) {
				minHeap.offer(minNode.next);
			}
			head = head.next;
		}	
		return previous.next;		
    }
}
