package com.interview.company.evernote.buildmanager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

public class BuildManager {
	Set<String> startTargets;
	Map<String, Target> allDependencyMap;
	Map<String, List<Target>> targetMap;
	
	public BuildManager() {
		startTargets = new HashSet<String>();
		allDependencyMap = new HashMap<String, Target>();
		targetMap = new HashMap<String, List<Target>>();
	}
	
	public void parseLine(String line) {
		String[] symbols = line.split(" ");
		List<Target> dependencies = targetMap.get(symbols[0]);
		if (dependencies==null) {
			dependencies = new ArrayList<Target>();
			targetMap.put(symbols[0], dependencies);
		}
		
		for (int i=1; i<symbols.length; i++) {
			Target target = allDependencyMap.get(symbols[i]);
			if (target == null) {
				target = new Target(symbols[i], false);
				allDependencyMap.put(target.name, target);
			}
			dependencies.add(target);			
		}
		
		Target startTarget = allDependencyMap.get(symbols[0]);
		if (startTarget!=null) {
			startTargets.remove(symbols[0]);
		} else {
			startTargets.add(symbols[0]);
		}		
	}
	
	public void print() {
		for (String startTarget : startTargets) {
			printStart(startTarget);
		}
	}
	
	public void printStart(String startTarget) {
		List<Target> dependencies = targetMap.get(startTarget);
		if (dependencies!=null) {
			for (Target dependency : dependencies) {
				if (!dependency.visited) {
					printStart(dependency.name);
					dependency.visited = true;
				}
			}
		}		
		System.out.print(startTarget + "->");
	}
	
	public static class Target {
		public String name;
		public boolean visited;
		
		public Target(String name, boolean visited) {
			this.name = name;
			this.visited = visited;
		}
	}
}
