package com.interview.datastructure.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    
	private List<String> keys;
	private Map<String, Object> cache;
	private int size;
	
	public LRUCache(int size) {
		this.size = size;
		this.keys = new ArrayList<String>();
		this.cache = new HashMap<String, Object>();
	}
	
	public Object get(String key) {
		//invalidate the usage
		if (cache.containsKey(key)) {
			keys.remove(key);
			keys.add(key);
		}
		return cache.get(key);
	}
	
	public void insert(String key, Object value) {
		//if full, remove the oldest object
		if (cache.size() == size) {
			String oldestKey = keys.get(0);
			keys.remove(0);
			cache.remove(oldestKey);
		}
		cache.put(key, value);
	}
}
