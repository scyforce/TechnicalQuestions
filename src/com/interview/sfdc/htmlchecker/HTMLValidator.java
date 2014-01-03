package com.interview.sfdc.htmlchecker;

import java.util.Scanner;

import java.util.Stack;

public class HTMLValidator {
	private Stack<HTMLTag> tagStack;
	
	public HTMLValidator() {
		tagStack = new Stack<HTMLTag>();
	}
	
	public boolean isStartLine(String line) {
		try {
			Integer.parseInt(line);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String preprocessLine(String line) {
		return (line!=null)?line.trim():line;
	}
	
	public String checkEndTag(String line, int lineNumber) {
		String message = "OK";
		System.out.println(tagStack.isEmpty());
		if (!tagStack.isEmpty()) {
			HTMLTag tag = tagStack.pop();
			HTMLError.EXPECTED_TAG_NOT_FOUND.setDescription("</"+tag.text+">");
			message = String.format("line %d: "+ HTMLError.EXPECTED_TAG_NOT_FOUND.getDescription(), lineNumber);		    					
		}
		return message;
	}
	
	public String parse(String line, int lineNumber) {
		Scanner scanner = new Scanner(line).useDelimiter("");
		String token = "";
		String message = "OK";
		while (scanner.hasNext()) {	
			String str = scanner.next();			
			if (str.equals("<")) {
				token = "";
			}
			token+=str;
			if (str.equals(">")) { 
				if (isValidHTMLTag(token)) {
				    HTMLTag tag = new HTMLTag(token);
				    HTMLError error = handleHTMLTag(tag);
				    if (error!=null) {
				    	message = String.format("line %d: "+ error.getDescription(), lineNumber);
				    }
					token = "";
			    } else {
				    message = String.format("line %d: "+ HTMLError.INCORRECT_TAG_FORMAT.getDescription(), lineNumber);
				}
			}
			if (!message.equalsIgnoreCase("OK")) {
			    return message;
			}
		}
		if (isHTMLTag(token) && !isValidHTMLTag(token)) {
			message = String.format("line %d: "+ HTMLError.INCORRECT_TAG_FORMAT.getDescription(), lineNumber);
		}
		return message;
	}
	
	public HTMLError handleHTMLTag(HTMLTag tag) {
	    HTMLError error = null;
		if (withinTagLimit(tag)) {	
	    	if (tag.isStartTag) {
	    		tagStack.push(tag);
	    	} else {
	    		if (!tagStack.isEmpty()) {		
	    			HTMLTag startTag = tagStack.pop();
	    			if (!startTag.text.equalsIgnoreCase(tag.text)) {
	    				HTMLError.EXPECTED_TAG_NOT_FOUND.setDescription("</"+startTag.text+">");
	    				error = HTMLError.EXPECTED_TAG_NOT_FOUND;		    					
	    			}
	    		} else {
	    			error = HTMLError.NO_BEGIN_TAG;
	    		}
	    	}
	    } else {	    		
	    	error = HTMLError.WRONG_LIMIT_TAG;
	    }	
	    return error;
	}
	
	public void resetValidator() {
		this.tagStack.clear();
	}
	
	private boolean withinTagLimit(HTMLTag tag) {
		return (tag.text.length()>0 && tag.text.length()<=10);
	}
	
	private boolean isHTMLTag(String tag) {
		return tag.startsWith("<") || tag.endsWith(">");
	}
	
	public boolean isValidHTMLTag(String tag) {
		return tag.startsWith("<") && tag.endsWith(">");
	}
}
