package com.interview.sfdc.subdirectory;

public enum COMMAND_TYPE {
    DIR ("dir"),
    CD ("cd"),
    MKDIR ("mkdir"),
    UP ("up");
    
    private String name;
    
    private COMMAND_TYPE(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
}
