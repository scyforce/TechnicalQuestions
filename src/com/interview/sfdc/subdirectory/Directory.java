package com.interview.sfdc.subdirectory;

import java.util.HashSet;
import java.util.Set;

public class Directory {
    private Set<Directory> subDirectories;
    private Directory parent;
    private String name;
    
    public Directory (String name) {
    	this.subDirectories = new HashSet<Directory>();	
    	this.name = name;
    }

	public Set<Directory> getSubDirectories() {
		return subDirectories;
	}

	public void setSubDirectories(Set<Directory> subDirectories) {
		this.subDirectories = subDirectories;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
