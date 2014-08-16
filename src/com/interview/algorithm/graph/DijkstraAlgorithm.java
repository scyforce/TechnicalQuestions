package com.interview.algorithm.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class DijkstraAlgorithm {
    public static int LARGE_NUMBER = 10000;
    public static String UNDEFINED = "undefined";
	
	public Hashtable<String, String> DijkstraAlgorithm(Hashtable<String, Hashtable<String, Integer>> ajacencyList, String source){
		//store shortest path from source to current calculating point
		Hashtable<String, Integer> distance = new Hashtable<String, Integer>();
		//store the paths
		Hashtable<String, String> previous = new Hashtable<String, String>();
		//store all need to be computed nodes
		List<String> nodes = new ArrayList<String>();
		
		//inialize the dist and previous;
		for (Entry<String, Hashtable<String, Integer>> entry : ajacencyList.entrySet()) {
			String key = entry.getKey();
			distance.put(key, LARGE_NUMBER);
			previous.put(key, UNDEFINED);
			nodes.add(key);
		}		
		distance.put(source, 0);
		
		String nextNode;
		Hashtable<String, Integer> neighbors;
		while(!nodes.isEmpty()){
			nextNode = findNode(distance, nodes);
			nodes.remove(nextNode);
			neighbors = ajacencyList.get(nextNode);						
			//make sure the shortest path from source to the destination
			for(Entry<String, Integer> entry : neighbors.entrySet()){
				int alt =  (distance.get(nextNode)).intValue()+entry.getValue();
				String neighbor = entry.getKey();
				if(alt<(distance.get(neighbor)).intValue()){
					distance.put(neighbor, alt);
					previous.put(neighbor, nextNode);
				}
			}
		}
		return previous;
	}
	
	//find the lowest cost between point A and point B
	public String findNode(Hashtable<String, Integer> dist, List<String> nodes){
    	int distance = LARGE_NUMBER;
    	String node = "";
    	for(Entry<String, Integer> entry : dist.entrySet()){
    		String key = entry.getKey();
    		if(nodes.contains(key)){
    			int value = entry.getValue().intValue();
    			if(value<distance){
    				distance = value;
    				node = key;
    			}
    		}
    	}
    	return node;
    }
    
	public void printOutPath(Hashtable<String, String> path, String source, String target) {
		for (Entry<String, String> entry : path.entrySet()) {
    		String currentNode = entry.getKey();
    		String previousNode = entry.getValue();
    		if (currentNode.equals(target)) {
    			List<String> pathList = new ArrayList<String>();
        		pathList.add(currentNode);
        		if (!UNDEFINED.equals(previousNode)) {
        			pathList.add(previousNode);
        		}   		
        		while (!previousNode.equals(source)&&!previousNode.equals(UNDEFINED)) {
        			previousNode = path.get(previousNode);
        			pathList.add(previousNode);
        		}
        		Collections.reverse(pathList);    		
        		int index = 0;
        		for (String node : pathList) {
        			System.out.print(node);
        			if (index!=pathList.size()-1) {
        				System.out.print("->");
        			}
        			index++;
        		}
        		System.out.println();
        		break;    		
    		}   		    				
    	}
	}
	
	public void printOutRoutes(Hashtable<String, String> path, String source){
		for (Entry<String, String> entry : path.entrySet()) {
    		String currentNode = entry.getKey();
    		String previousNode = entry.getValue();
    		
    		List<String> pathList = new ArrayList<String>();
    		pathList.add(currentNode);
    		if (!UNDEFINED.equals(previousNode)) {
    			pathList.add(previousNode);
    		}   		
    		while (!previousNode.equals(source)&&!previousNode.equals(UNDEFINED)) {
    			previousNode = path.get(previousNode);
    			pathList.add(previousNode);
    		}
    		Collections.reverse(pathList);    		
    		int index = 0;
    		for (String node : pathList) {
    			System.out.print(node);
    			if (index!=pathList.size()-1) {
    				System.out.print("->");
    			}
    			index++;
    		}
			System.out.println();
    	}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hashtable<String, Hashtable<String, Integer>> graph = new Hashtable<String, Hashtable<String,Integer>>();
		
		Hashtable<String, Integer> neighbors1 = new Hashtable<String, Integer>();
		neighbors1.put("B", 2);
		neighbors1.put("C", 1);		
		graph.put("A", neighbors1);

		Hashtable<String, Integer> neighbors2 = new Hashtable<String, Integer>();
		neighbors2.put("D", 3);
		graph.put("B", neighbors2);
		
		Hashtable<String, Integer> neighbors3 = new Hashtable<String, Integer>();
		neighbors3.put("D", 1);
		graph.put("C", neighbors3);
		
		Hashtable<String, Integer> neighbors4 = new Hashtable<String, Integer>();
		neighbors4.put("E", 2);
		neighbors4.put("F", 3);
		graph.put("D", neighbors4);
		
		Hashtable<String, Integer> neighbors5 = new Hashtable<String, Integer>();
		graph.put("E", neighbors5);
		
		Hashtable<String, Integer> neighbors6 = new Hashtable<String, Integer>();
		graph.put("F", neighbors6);
		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
		Hashtable<String, String> path = dijkstra.DijkstraAlgorithm(graph, "A");
		dijkstra.printOutRoutes(path, "A");
		dijkstra.printOutPath(path, "A", "E");

	}

}
