package com.interview.sfdc.htmlchecker;

public class HTMLTag {
    public boolean isStartTag;
    public String text;
    
    public HTMLTag(String tag) {
    	formTag(tag);
    }
    
    private void formTag(String tag) {
    	if (!tag.startsWith("</")) this.isStartTag = true;
    	this.text = tag.replace("<", "").replace(">", "").replace("/", "");
    }
}
