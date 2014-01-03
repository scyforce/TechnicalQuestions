package com.interview.sfdc.subdirectory;

import java.util.Set;

public class DirectoryManager {
	
	public DirectoryCommand command;
	public Directory currentDirectory;
	public DirectoryOutputWriter outputWriter;
	
	public DirectoryManager(String directoryName) {
		this.command = DirectoryCommandImpl.getInstance();
		this.currentDirectory = new Directory(directoryName);
		this.outputWriter = DirectoryOutputWritterImpl.getInstance();
	}
	
	public String executeCommand(String[] args) {
		String commandType = args[0];
		String argument = "";
		if (args.length>1) {
			argument = args[1];
		}
		if (commandType==null) {
			return "Invalid command";
		}
		String output = "";
		Directory directory = null;
		if (args[0].equals(COMMAND_TYPE.CD.getName())) {
			directory = command.changeDirectory(this.currentDirectory, argument);
		    if (directory!=null) {
		    	currentDirectory = directory;
		    }
		    output = outputWriter.outputChangeDirectoryCommand(directory);
		} else if (commandType.equals(COMMAND_TYPE.DIR.getName())) {
			Set<Directory> subs = command.listDirectory(currentDirectory);
			output = outputWriter.outputDirCommand(currentDirectory, subs);
		} else if (commandType.equals(COMMAND_TYPE.MKDIR.getName())) {
			directory = command.makeDirectory(currentDirectory, argument);					
			output = outputWriter.outputMakeDirectoryCommand(directory);
		} else if (commandType.equals(COMMAND_TYPE.UP.getName())) {
            directory = command.upDirectory(currentDirectory);
			if (directory!=null) {
				currentDirectory = directory;
			}				
			output = outputWriter.outputUpCommand(directory);
		} else {
			output = "Command not supported";
		}
		return output;
	}
}
