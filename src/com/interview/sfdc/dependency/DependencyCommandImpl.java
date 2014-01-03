package com.interview.sfdc.dependency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependencyCommandImpl implements DependencyCommand {

	@Override
	public void depend(ProgramDependency programDependency, String program,
			Set<String> dependencies) {
		//construct dependency map
		Map<String, Set<String>> dependencyMap = programDependency.getDependencyMap();
		Set<String> currentDepdencies = dependencyMap.get(program);
    	//avoid duplicate dependencies and assume we can declare dependencies multiple times
    	if (currentDepdencies!=null) {
    		currentDepdencies.addAll(dependencies);
    	} else {
    		currentDepdencies = dependencies;
    	}
    	dependencyMap.put(program, currentDepdencies);
    	
    	//construct reverse dependency map
    	Map<String, Set<String>> reverseDependencyMap = programDependency.getReverseDepdencyMap();
    	for (String dependency : dependencies) {
    		Set<String> reverseDependencies = reverseDependencyMap.get(dependency);
    		if (reverseDependencies==null) {
    			reverseDependencies = new HashSet<String>();
    			reverseDependencyMap.put(dependency, reverseDependencies);
    		}
    		reverseDependencies.add(program);
    	}
    	
    	//programDependency.printDepdencies(dependencyMap);
    	//programDependency.printDepdencies(reverseDependencyMap);
    	
	}

	@Override
	public String install(ProgramDependency programDependency, String program) {
		
		//programs to be installed
		List<String> installedPrograms = new ArrayList<String>();
		Map<String, Set<String>> dependencyMap = programDependency.getDependencyMap();
		List<String> currentInstalledPrograms = programDependency.getInstalledPrograms();
		Set<String> currentDependencies = dependencyMap.get(program);
		if (currentDependencies!=null) {		
			for (String currentDependency : currentDependencies) {
				//check if the dependent program is already installed or not
				if (!currentInstalledPrograms.contains(currentDependency)) {
					installedPrograms.add(currentDependency);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		//check the program is already installed or not
		if (!currentInstalledPrograms.contains(program)) {
			installedPrograms.add(program);
			currentInstalledPrograms.addAll(installedPrograms);	
			//print out the programs to be installed
			for (String installedProgram : installedPrograms) {
				sb.append("\tinstalling " + installedProgram + "\n");
			}
		} else {
			sb.append("\t" + program + " is already installed.\n");
		}
		
		return sb.toString();
	}

	@Override
	public String remove(ProgramDependency programDependency, String program) {
		Map<String, Set<String>> dependencyMap = programDependency.getDependencyMap();
		List<String> currentInstalledPrograms = programDependency.getInstalledPrograms();
		Map<String, Set<String>> reverseDependencyMap = programDependency.getReverseDepdencyMap();
		boolean canRemove = true;
		StringBuilder sb = new StringBuilder();
		//check if the program is installed or not
		if (currentInstalledPrograms.contains(program)) {
			Set<String> reverseDependencies = reverseDependencyMap.get(program);
			if (reverseDependencies!=null) {
            	//check all programs depend on the program itself is installed or not
				//if not installed, we can remove otherwise we can not 
				for (String currentInstalledProgram : currentInstalledPrograms) {
            		if(reverseDependencies.contains(currentInstalledProgram)) {
            			canRemove = false;
            			break;
            		}
            	}
            }
			//if we can remove this program, try to remove all its dependencies
			if (canRemove) {
				currentInstalledPrograms.remove(program);
				sb.append("\tRemoving "+program+"\n");
				//check if its dependencies can be removed;			
				canRemove = true;
				Set<String> dependencies = dependencyMap.get(program);
				for (String dependency : dependencies) {
					reverseDependencies = reverseDependencyMap.get(dependency);
					if (reverseDependencies!=null) {
		            	for (String currentInstalledProgram : currentInstalledPrograms) {
		            		if(reverseDependencies.contains(currentInstalledProgram)) {
		            			canRemove = false;
		            			break;
		            		}
		            	}
		            }
					
					if (canRemove) {
						currentInstalledPrograms.remove(dependency);
						sb.append("\tRemoving "+dependency+"\n");
					}
				}		
			} else {
				sb.append("\t"+program+" is still needed.\n");
			}
			
		//never install this program before, can not remove
		} else {
			sb.append("\t" + program + " is not installed.\n");
		}
		return sb.toString();
	}

	@Override
	public String list(ProgramDependency programDependency) {
		List<String> currentInstalledPrograms = programDependency.getInstalledPrograms();
		StringBuilder sb = new StringBuilder();
		for (String currentInstalledProgram : currentInstalledPrograms) {
			sb.append("\t"+currentInstalledProgram+"\n");
		}
		return sb.toString();
	}
	
}
