package com.interview.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**

	Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
	
	
	OJ's undirected graph serialization:
	Nodes are labeled uniquely.
	
	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	
	The graph has a total of three nodes, and therefore contains three parts as separated by #.
	
	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	Second node is labeled as 1. Connect node 1 to node 2.
	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	Visually, the graph looks like the following:
	
	       1
	      / \
	     /   \
	    0 --- 2
	         / \
	         \_/

* @author shuchun.yang
*
*/

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) {
        	return node;
        }
        
        //BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();	
        //map is used to store original map -> copied map
        Map<UndirectedGraphNode, UndirectedGraphNode> copiedMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        queue.add(node);
        copiedMap.put(node, newNode);
        
        while (!queue.isEmpty()) {
        	UndirectedGraphNode current = queue.poll();
        	ArrayList<UndirectedGraphNode> neighbors = current.neighbors;
        	for (UndirectedGraphNode neighbor : neighbors) {
        		UndirectedGraphNode copiedNode = copiedMap.get(neighbor);
        		//never visited before
        		if (copiedNode==null) {
        			copiedNode = new UndirectedGraphNode(neighbor.label);
        			//map the new node with original node
        			copiedMap.put(neighbor, copiedNode);
        			//enqueue the neighbor
        			queue.add(neighbor);       			       			
        		} 
        		//either a loop or a different node, copy all neighbors
    			copiedMap.get(current).neighbors.add(copiedNode);
        	}
        }
        
		return newNode;
    }
}
