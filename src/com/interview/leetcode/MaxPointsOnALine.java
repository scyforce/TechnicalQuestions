package com.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**

	Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

* @author shuchun.yang
*
*/

public class MaxPointsOnALine {
	public static void main(String[] args) {
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,0);
		
		Point[] points = {p1,p2};
		
		MaxPointsOnALine m = new MaxPointsOnALine();
		
		System.out.println(m.maxPoints(points));
	}
	
	// calculate points on a line - find a line's slop then try to see if next line have the same slop
	public int maxPoints(Point[] points) {
        if (points==null||points.length==0) {
        	return 0;
        }
        
        Map<Double, Integer> map=new HashMap<Double, Integer>();;
        int maxPoints=1;  
        
        for(int i=0; i<points.length; i++){
            // shared point changed, map should be cleared and server the new point
            map.clear();
            
            // maybe all points contained in the list are same points,and same points' k is 
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);
            
            int duplicate=0;
            
            for(int j=i+1; j<points.length; j++){                
               if (points[j].x==points[i].x&&points[j].y==points[i].y){
                   duplicate++;
               } else {
            	   // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                   // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0 problem
                   
                   // if the line through two points are parallel to y coordinator, then K(slop) is 
                   // Integer.MAX_VALUE
                   double slop = (points[j].x-points[i].x) == 0 
                		   			? Integer.MAX_VALUE
                		   			: 0.0 + (points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                  
                   if (map.containsKey(slop)){               	   
                       map.put(slop, map.get(slop)+1);
                   } else{
                      map.put(slop, 2);
                   }
               }           
           }
           
          for (int currMaxPoints: map.values()){            
              maxPoints = Math.max(maxPoints, currMaxPoints+duplicate);
          }          
        }
        
        return maxPoints;	
    }
}
