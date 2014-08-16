package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	
	You may assume that the intervals were initially sorted according to their start times.
	
	Example 1:
	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
	
	Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
	
	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 * @author shuchun.yang
 *
 */
public class InsertInterval {
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		
		Interval newInterval = new Interval(4,9);
		InsertInterval ii = new InsertInterval();
		System.out.println(Arrays.toString(ii.insert(intervals, newInterval).toArray()));
		
		System.out.println(Arrays.toString(ii.insert1(intervals, newInterval).toArray()));
	}
	
	public ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> results = new ArrayList<Interval>();
		if (newInterval==null) {
			return intervals;
		}
		
		if (intervals==null||intervals.isEmpty()) {
			results.add(newInterval);
			return results;
		}
		
		for (int i=0; i<intervals.size(); i++) {
			Interval interval = intervals.get(i);
			
			if (interval.end<newInterval.start) {
				results.add(interval);
			} else if (interval.start>newInterval.end) {
				results.add(newInterval);
				newInterval = interval;
			} else if (interval.end>=newInterval.start || interval.start<=newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
			}
		}
		
		results.add(newInterval);
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> results = new ArrayList<Interval>();
        
        if (intervals==null || intervals.isEmpty()) {
        	return results;
        }
        
        for (Interval interval : intervals) {
        	//interval - [1,2] newInterval - [10,20]
        	if (interval.end<newInterval.start) {
        		results.add(interval);
        	//interval - [5,6] newInterval - [1,2]
        	} else if (newInterval.end<interval.start) {
        		results.add(newInterval);
        		newInterval = interval;
        	//interval - [3,7] newInterval - [4,9], each time there is an overlap, create a newInterval and take the min start and max end
        	} else if (interval.end >= newInterval.start || interval.start<=newInterval.end) {
        		newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
        	}
        }
        results.add(newInterval);
        return results;
    }
}
