package com.interview.sfdc.subdirectory;

import java.util.Set;

public class DirectoryOutputWritterImpl implements DirectoryOutputWriter {
    private static DirectoryOutputWriter outputWriter;
    
    private DirectoryOutputWritterImpl() {}
	
    public static synchronized DirectoryOutputWriter getInstance() {
        if (outputWriter == null) {
        	outputWriter = new DirectoryOutputWritterImpl();
        }
        return outputWriter;
    }
    
	@Override
	public String outputDirCommand(Directory directory, Set<Directory> subDirectories) {
		String directoryPath = "";
		Directory parentDirectory = directory;
		while (parentDirectory != null) {
			directoryPath = "\\" + parentDirectory.getName() + directoryPath;
			parentDirectory = parentDirectory.getParent();
		}
		if (!directoryPath.equals("")) {
			directoryPath = directoryPath.substring(1);
		}
		String message = String.format("Directory of %s:\n", directoryPath);
		if (subDirectories.isEmpty()) {
			message += "No subdirectories\n";
		} else {
			String subMessage = "";
			for (Directory subDirectory : subDirectories) {
				subMessage += "\t"+subDirectory.getName();
			}
			message += subMessage.substring(1) + "\n";
		}		
		return message;
	}

	@Override
	public String outputChangeDirectoryCommand(Directory subDirectory) {
		String message = "";
		if (subDirectory == null) {
			message = "Subdirectory does not exist\n";
		}
		return message;
	}

	@Override
	public String outputMakeDirectoryCommand(Directory subDirectory) {
		String message = "";
		if (subDirectory != null) {
			message = "Subdirectory already exists\n";
		}
		return message;
	}

	@Override
	public String outputUpCommand(Directory directory) {
		String message = "";
		if (directory==null) {
			message = "Cannot move up from root directory\n";
		}
		return message;
	}
}
