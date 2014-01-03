package com.interview.sfdc.subdirectory;

import java.util.Set;

public interface DirectoryOutputWriter {
    public String outputDirCommand(Directory directory, Set<Directory> subDirectories);
    public String outputChangeDirectoryCommand(Directory subDirectoryName);
    public String outputMakeDirectoryCommand(Directory subDirectoryName);
    public String outputUpCommand(Directory directory);
}
