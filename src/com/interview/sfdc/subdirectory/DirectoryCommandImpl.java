package com.interview.sfdc.subdirectory;

import java.util.Set;

public class DirectoryCommandImpl implements DirectoryCommand {
    private static DirectoryCommand directoryCommand;
    
    private DirectoryCommandImpl() {}
	
    public static synchronized DirectoryCommand getInstance() {
        if (directoryCommand == null) {
        	directoryCommand = new DirectoryCommandImpl();
        }
        return directoryCommand;
    }
	
	@Override
	public Directory makeDirectory(Directory currentDirectory, String subDirectoryName) {
		Directory subDirectory = changeDirectory(currentDirectory, subDirectoryName);
		if (subDirectory != null) {
			return subDirectory;
		}
		subDirectory = new Directory(subDirectoryName);
		subDirectory.setParent(currentDirectory);
		currentDirectory.getSubDirectories().add(subDirectory);
		return null;
	}

	@Override
	public Set<Directory> listDirectory(Directory directory) {
		return directory.getSubDirectories();		
	}

	@Override
	public Directory changeDirectory(Directory currentDirectory, String subDirectoryName) {
		for (Directory subDirectory : currentDirectory.getSubDirectories()) {
    		if (subDirectory.getName().equalsIgnoreCase(subDirectoryName)) {
    			return subDirectory;
    		}
    	}
		return null;		
	}

	@Override
	public Directory upDirectory(Directory directory) {
		return directory.getParent();		
	}

}
