package com.interview.sfdc.dependency;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//a wrapper class maintains dependency logic
public class DependencyManager {
    public ProgramDependency programDependency;
    public DependencyCommand dependencyCommand;
    
    public DependencyManager() {
    	this.programDependency = new ProgramDependency();
    	this.dependencyCommand = new DependencyCommandImpl();
    }
    
    //check if the input is the end of the line
    public boolean isEndLine(String line) {
    	return DependencyConstants.END.equals(line);
    }
    
    //dispatch the logic based on the command name
    public String executeCommand(String line) {
    	Scanner scanner = new Scanner(line).useDelimiter("\\s+");
    	String commandName = scanner.next();
    	String message = "";
    	if (DependencyConstants.DEPEND_COMMAND.equals(commandName)) {
    		String program = scanner.next();
    		Set<String> dependencies = new HashSet<String>();
    		while (scanner.hasNext()) {
    			dependencies.add(scanner.next());
    		}
    		this.dependencyCommand.depend(programDependency, program, dependencies);
    	} else if (DependencyConstants.INSTALL_COMMAND.equals(commandName)) {
    		String program = scanner.next();
    		message = this.dependencyCommand.install(programDependency, program);
    	} else if (DependencyConstants.REMOVE_COMMAND.equals(commandName)) {
    		String program = scanner.next();
    		message = this.dependencyCommand.remove(programDependency, program);
    	} else if (DependencyConstants.LIST_COMMAND.equals(commandName)) {
    		message = this.dependencyCommand.list(programDependency);
    	} else {
    		throw new UnsupportedOperationException("This command is not yet supported");
    	}
		return message;
    }
}
