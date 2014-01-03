package com.interview.sfdc.packagedependency;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class DependencyProcessor {
    public Hashtable<String, List<String>> packageTable;
	
    public DependencyProcessor() {
    	packageTable = new Hashtable<String, List<String>>();
    }
    
	public void generatePackageDependency(String line) {
		Scanner scanner = new Scanner(line).useDelimiter(" ");
		String newPackage = scanner.next();
		List<String> requiredPackage = new ArrayList<String>();
		packageTable.put(newPackage, requiredPackage);
		while(scanner.hasNext()) {
			String pack = scanner.next();
			if (!"0".equalsIgnoreCase(pack) && !requiredPackage.contains(pack) && !newPackage.equalsIgnoreCase(pack)) {
				requiredPackage.add(pack);
			}
		}		
	}
	
	private Stack<String> findNoDependencyPackage() {
		//find no dependency package;
		Stack<String> noDependencyPackages = new Stack<String>();
		for (String key : packageTable.keySet()) {
			List<String> requiredPackage = packageTable.get(key);
			if (requiredPackage.isEmpty()) {
				noDependencyPackages.push(key);				
			}
		}
		return noDependencyPackages;
	}
	
	public int installPackage() {
		Stack<String> noDependencyPackages = findNoDependencyPackage();
		int installedPackage = 0;
		while(!noDependencyPackages.isEmpty()) {
			System.out.println("installed package  - " + installedPackage);
			String noDependency = noDependencyPackages.pop();
			installedPackage++;
			//remove already installed package from package table
			packageTable.remove(noDependency);
			for (Entry<String, List<String>> entry : packageTable.entrySet()) {
				String key = entry.getKey();
				List<String> value = entry.getValue();
				if (value.contains(noDependency)) {
					System.out.println("for " + key + " remove " + noDependency);
					//remove package dependency for this package
					value.remove(noDependency);
				}
				//if package has no dependencies, add it to no dependency packages
				if (value.isEmpty() && !noDependencyPackages.contains(key)) {
					System.out.println("Key " + key + " has no dep ");
					noDependencyPackages.push(key);
				}
			}
		}
		return installedPackage;
	}
}
