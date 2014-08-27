package com.interview.leetcode;

/**

	A linked list is given such that each node contains an additional random pointer 
	
	which could point to any node in the list or null.
	
	Return a deep copy of the list.

 * @author shuchun.yang
 *
 */
public class CopyListWithRandomPointer {
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(-1);
		RandomListNode l1 = new RandomListNode(1);
		head.next = l1;
		head.random = null;
		l1.next = null;
		l1.random = null;
		
		CopyListWithRandomPointer c = new CopyListWithRandomPointer();
		c.copyRandomList(head);
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) {
        	return head;
        }
        
        RandomListNode current = head;
        //1.insert the copy of nth node between original nth and (n+1)th
        while (current!=null) {
        	RandomListNode next = current.next;
        	RandomListNode copy = new RandomListNode(current.label);
        	current.next = copy;
        	copy.next = next;
        	current = next;
        }
        
        //2. set the random pointer for each copy node
        current = head;
        RandomListNode newHead = current.next;
        while (current!=null) {
        	if (current.random!=null) {
        		//now random.next is the copied node
        		current.next.random = current.random.next;
        	}
        	current = current.next.next;
        }
        
        //3. recover the original node and copy node
        current = head;
        while (current!=null) {
        	RandomListNode next = current.next.next;
        	RandomListNode copy = current.next;
        	current.next = next;
        	if (copy.next!=null) {
        		copy.next = copy.next.next;
        	}       	
        	current = next;
        }
        
        return newHead;
    }
}
