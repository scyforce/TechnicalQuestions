package com.interview.leetcode;

/**
	
	Merge two sorted linked lists and return it as a new list. 
	
	The new list should be made by splicing together the nodes of the first two lists.

 * @author shuchun.yang
 *
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1==null&&l2==null) {
			return null;
		}
		
		if (l1==null) {
			return l2;
		}
		
		if (l2==null) {
			return l1;
		}
		
		ListNode result = null;
		ListNode head = null;
		if (l1.val<l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		result = head;
		
		while (l1!=null&&l2!=null) {
			if (l1.val<l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		
		if (l1!=null) {
			head.next = l1;
		} 
		if (l2!=null) {
			head.next = l2;
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1==null&&l2==null) {
			return null;
		}
		
		if (l1==null) {
			return l2;
		}
		
		if (l2==null) {
			return l1;
		}
		
		ListNode result = null;
		if (l1.val<l2.val) {
			result = l1;
			l1 = l1.next;
		} else {
			result = l2;
			l2 = l2.next;
		}
		ListNode head = result;
		
		while (l1!=null&&l2!=null) {
			if (l1.val<l2.val) {
				result.next = l1;
				l1 = l1.next;				
			} else {
				result.next = l2;
				l2 = l2.next;
			}
			result = result.next;
		}
		
		if (l1!=null) {
			result.next = l1;
		}
		
		if (l2!=null) {
			result.next = l2;
		}
		
		return head;
        
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		
		ListNode head = new ListNode(1);
		ListNode l2 = head;
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		m.mergeTwoLists(l1, l2);
	}
	
}
