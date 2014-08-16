package com.interview.leetcode;

import java.util.ArrayList;

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		this.label = x; 
		this.neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}