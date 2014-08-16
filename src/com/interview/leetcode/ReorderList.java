package com.interview.leetcode;

/**

	Given a singly linked list L: L0->L1->É->Ln-1->Ln,
	reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->É
	
	You must do this in-place without altering the nodes' values.
	
	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}.

 * @author shuchun.yang
 *
 */
public class ReorderList {
	public static void main(String[] args) {
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(4);
		ListNode t5 = new ListNode(5);
		t1.next = t2; t2.next = t3; t3.next = t4;
		t4.next = t5;
		
		ReorderList l = new ReorderList();
		l.reorderList(t1);
		t1.print();
	}
	
	//the overall idea is, break the list into two by middle
	//reverse the second linklist, then merge them
	public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null) {
        	return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow.next!=null&&fast!=null&&fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode right = slow.next;
        slow.next = null;
        
        right = reverse(right);
        merge(head, right);
    }
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode newHead = l1;
		
		while (l1!=null&&l2!=null) {
			ListNode l1Next = l1.next;			
			ListNode l2Next = l2.next;
			l1.next = l2;
			l2.next = l1Next;
			l1 = l1Next;
			l2 = l2Next;			
		}
		
		return newHead;
	}
	
	public ListNode reverse(ListNode l2) {
		ListNode previous = new ListNode(0);
		previous.next = l2;
		
		ListNode last = l2;
		ListNode current = last.next;
		while(current!=null) {
			last.next = current.next;
			current.next = previous.next;
			previous.next = current;
			current = last.next;
		}
		
		return previous.next;
	}
}
