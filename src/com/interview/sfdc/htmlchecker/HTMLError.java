package com.interview.sfdc.htmlchecker;

public enum HTMLError {
	    INCORRECT_TAG_FORMAT ("bad character in tag name"),
	    EXPECTED_TAG_NOT_FOUND ("expected %s"),
	    WRONG_LIMIT_TAG ("too many/few characters in tag name"),
	    NO_BEGIN_TAG ("no matching begin tag");
	    
	    private String description;
	    
	    HTMLError (String description) {
	    	this.description = description;
	    }
	    
	    public String getDescription() {
	    	return this.description;
	    }
	    
	    public void setDescription(String tag){
	    	this.description = String.format(this.description, tag);
	    }

}
