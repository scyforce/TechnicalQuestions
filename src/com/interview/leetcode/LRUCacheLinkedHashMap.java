package com.interview.leetcode;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**

	Design and implement a data structure for Least Recently Used (LRU) cache. 
	
	It should support the following operations: get and set.
	
	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	
	set(key, value) - Set or insert the value if the key is not already present. 
					  When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 * @author shuchun.yang
 *
 */
public class LRUCacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {  
    private int capacity;  
    private static final long serialVersionUID = 1L;  
  
    public LRUCacheLinkedHashMap(int capacity) {  
        super(capacity, 0.75f, true); // 'true' for accessOrder.  
        this.capacity = capacity;  
    }  
  
    public boolean removeEldestEntry(Entry<K, V> entry) {  
        return (size() > this.capacity);  
    }  
}  
