package com.interview.leetcode;

/**

	Given a linked list, swap every two adjacent nodes and return its head.
	
	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 * @author shuchun.yang
 *
 */
public class SwapNodesInPairs {
	
	public ListNode swapPairs1(ListNode head) {
		if (head==null||head.next==null) {
			return head;
		}
		
		ListNode newHead = head.next;
		ListNode previous = new ListNode(0);
		previous.next = head;
		
		while (head!=null && head.next!=null) {
			ListNode next = head.next;
			ListNode nextNext = next.next;
			
			//0 -> 2
			previous.next = next;
			//2 -> 1
			next.next = head;
			//1 -> 3
			head.next = nextNext;
			//now 1 is the previous node of the pair
			previous = head;
			//now 3 is the new head
			head = nextNext;
		}
		
		return newHead;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) {
        	return head;
        }
        

        ListNode newHead = head.next;
        //dummy node
        ListNode previous = new ListNode(0);
        previous.next = head;
        ListNode current = head;
        
        while (current!=null && current.next!=null) {
        	ListNode temp = current.next.next;
        	previous.next = current.next;
        	current.next.next = current;
        	current.next = temp;
        	previous = current;
        	current = temp;
        }
        
        return newHead;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode nextNode = new ListNode(2);
		//ListNode nextNextNode = new ListNode(3);
		//ListNode nextNextNextNode = new ListNode(4);
		head.next = nextNode;
		//nextNode.next = nextNextNode;
		//nextNextNode.next = nextNextNextNode;
		
		SwapNodesInPairs s = new SwapNodesInPairs();
		ListNode newHead = s.swapPairs(head);
		
		
		while (newHead!=null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}
