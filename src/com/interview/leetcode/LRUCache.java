package com.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**

	Design and implement a data structure for Least Recently Used (LRU) cache. 
	
	It should support the following operations: get and set.
	
	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	
	set(key, value) - Set or insert the value if the key is not already present. 
					  When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 * @author shuchun.yang
 *
 */
public class LRUCache {
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;
	private Map<Integer, DoubleLinkedListNode> cache;
	private int capacity;
	private int length;
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2,1);
		cache.set(1,1);
		System.out.println(cache.get(2));
		cache.set(4,1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
	
	public LRUCache(int capacity) {
		this.cache = new HashMap<Integer, LRUCache.DoubleLinkedListNode>();
        this.capacity = capacity;
	}
   
    private void setHead(DoubleLinkedListNode node) {
    	//set the node as the new head
    	node.pre = null;
    	node.post = head;
    	if (head!=null) {
    		head.pre = node;
    	}
    	head = node;
    	if (tail==null) {
    		tail = node;
    	}
    }
    
    private void removeNode(DoubleLinkedListNode node) {
    	DoubleLinkedListNode pre = node.pre;
    	DoubleLinkedListNode post = node.post;
    	
    	//update the pre.post pointer
    	if (pre!=null) {
    		pre.post = post;
    	} else {
    		head = post;
    	}
    	
    	//update the post.pre pointer
    	if (post!=null) {
    		post.pre = pre;
    	} else {
    		tail = pre;
    		if (tail!=null) {
    			tail.post = null;
    		}
    	}    	
    }
    
	//update the access order of the key-value pair
    public int get(int key) {
    	//invalidate the cache;
        if (cache.containsKey(key)) {
        	DoubleLinkedListNode latest = cache.get(key);
        	removeNode(latest);
        	setHead(latest);
        	return latest.val;
        } else {
        	return -1;
        }
    }
    
    public void set(int key, int value) {
        //update existing key-value and the access order
    	if (cache.containsKey(key)) {
        	DoubleLinkedListNode oldest = cache.get(key);
        	oldest.val = value;
        	removeNode(oldest);
        	setHead(oldest);
        } else {
        	DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
        	if (length < capacity) {
        		cache.put(key, newNode);
        		setHead(newNode);
        		length = length + 1;
        	} else {
        		cache.remove(tail.key);        		
        		cache.put(key, newNode);
        		removeNode(tail);
        		setHead(newNode);
        	}
        }
    }
    
    class DoubleLinkedListNode {
    	public int key;
    	public int val;
    	public DoubleLinkedListNode pre;
    	public DoubleLinkedListNode post;
    	
    	public DoubleLinkedListNode(int key, int val) {
    		this.val = val;
    		this.key = key;
    	}
    }
}
