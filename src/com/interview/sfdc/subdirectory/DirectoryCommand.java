package com.interview.sfdc.subdirectory;

import java.util.Set;

public interface DirectoryCommand {
	public Directory makeDirectory(Directory currentDirectory, String subDirectoryName);
	public Set<Directory> listDirectory(Directory directory);
	public Directory changeDirectory(Directory currentDirectory, String subDirectoryName);
	public Directory upDirectory(Directory directory);
	
}
