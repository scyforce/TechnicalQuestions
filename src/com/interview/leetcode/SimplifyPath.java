package com.interview.leetcode;

/**

	Given an absolute path for a file (Unix-style), simplify it.
	
	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	click to show corner cases.
	
	Corner Cases:
	Did you consider the case where path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".

 * @author shuchun.yang
 *
 */
public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		
		String path = "/home/";
		String simplePath = s.simplifyPath(path);
		System.out.println(simplePath);
		
		path = "/a/./b/../../c/";
		simplePath = s.simplifyPath(path);
		System.out.println(simplePath);
		
		path = "/../";
		simplePath = s.simplifyPath(path);
		System.out.println(simplePath);
		
		path = "/home//foo/";
		simplePath = s.simplifyPath(path);
		System.out.println(simplePath);
		
		path = "/../.";
		simplePath = s.simplifyPath(path);
		System.out.println(simplePath);
		
		path = "/a/./../b";
		simplePath = s.simplifyPath(path);
		System.out.println(simplePath);
		
		path = "/...";
		simplePath = s.simplifyPath(path);
		System.out.println(simplePath);
	}
	
	public String simplifyPath(String path) {
        if (path==null||path.isEmpty()) {
        	return path;
        }

        StringBuilder simplePath = new StringBuilder();
        String[] pathArray = path.split("/");
        
        simplePath.append("/");
        for (int i=1; i<pathArray.length; i++) {
        	String sub = pathArray[i];
        	//if you see .., delete the its parent path
        	if (sub.equals("..")) {
        		if (simplePath.length()>1) {
    				int startIndex = simplePath.lastIndexOf("/");
    				if (startIndex == 0) {
    					startIndex = 1;
    				}
    				simplePath.delete(startIndex, simplePath.length());
    			}
        	//valid folder, if you see a '/' don't add it again.
        	} else if (!sub.isEmpty()){
        		if (simplePath.charAt(simplePath.length()-1)!='/') {
        			simplePath.append("/");
        		}   		
        		simplePath.append(sub);
        	}
        }
        
        return simplePath.toString();
    }
}
