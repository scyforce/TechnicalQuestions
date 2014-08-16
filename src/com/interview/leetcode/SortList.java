package com.interview.leetcode;

/**

	Sort a linked list in O(n log n) time using constant space complexity.

 * @author shuchun.yang
 *
 */
public class SortList {
	public static void main(String[] args) {
		ListNode t1 = new ListNode(12);
		ListNode t2 = new ListNode(7);
		ListNode t3 = new ListNode(6);
		ListNode t4 = new ListNode(15);
		//ListNode t5 = new ListNode(4);
		t1.next = t2; t2.next = t3; t3.next = t4;
		//t4.next = t5;
		
		SortList l = new SortList();
		ListNode result = l.sortList(t1);
		result.print();
	}
	
	public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) {
        	return head;
        }
        
        int length = 0;
        ListNode temp = head;
        while(temp!=null) {
        	length = length + 1;
        	temp = temp.next;
        }
        
        int middle = length/2;
        
        ListNode left = head;
        ListNode right = null;
		temp = head;
		int countHalfLength = 0;
		while (countHalfLength<middle && temp!=null) {
			countHalfLength++;
			
			//***point the previous node of the right node to null thus break the list into two
			if (countHalfLength == middle) {
				right = temp.next;
				temp.next = null;
			}
			temp = temp.next;
		}
        
        left = sortList(left);
        right = sortList(right);
        
        ListNode result = mergeTwoSortedList(left, right);
        return result;
    }
	
	public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
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
}
