package com.interview.sfdc.dependency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.Set;
import java.util.Map;

public class ProgramDependency {
	//program -> Set of dependency
    private final Map<String, Set<String>> dependencyMap;
    //program -> Set of programs who depends on the program
    private final Map<String, Set<String>> reverseDependencyMap;
    //installed programs
    private final List<String> installedPrograms;
    
    public ProgramDependency() {
    	dependencyMap = new HashMap<String, Set<String>>();
    	reverseDependencyMap = new HashMap<String, Set<String>>();
    	installedPrograms = new ArrayList<String>();
    }
    
    public Map<String, Set<String>> getDependencyMap() {
    	return this.dependencyMap;
    }
    
    public List<String> getInstalledPrograms() {
    	return this.installedPrograms;
    }
    
    public Map<String, Set<String>> getReverseDepdencyMap() {
    	return this.reverseDependencyMap;
    }
    
    //utility method to print out map
    public void printDepdencies(Map<String, Set<String>> map) {
    	System.out.println("-------PRINT OUT DEPDENCY MAP-----------");
    	for (Entry<String, Set<String>> entry : map.entrySet()) {
    		System.out.println(entry.getKey() + " - " + Arrays.toString(entry.getValue().toArray()));
    	}
    	System.out.println("-------END-----------");
    }
}
