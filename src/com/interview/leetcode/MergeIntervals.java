package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
	Given a collection of intervals, merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
	
 * @author shuchun.yang
 *
 */
public class MergeIntervals {
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2,3));
		intervals.add(new Interval(4,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,9));
		intervals.add(new Interval(1,10));
		
		MergeIntervals mi = new MergeIntervals();
		System.out.println(Arrays.toString(mi.merge1(intervals).toArray()));
		
		System.out.println(Arrays.toString(mi.merge(intervals).toArray()));
	}
	
	
	public ArrayList<Interval> merge1(ArrayList<Interval> intervals) {
		ArrayList<Interval> results = new ArrayList<Interval>();
		if (intervals==null||intervals.isEmpty()) {
			return results;
		}
		
		Collections.sort(intervals, new Comparator<Interval> () {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
			
		});
		
		Interval interval = intervals.get(0);
		
		for (int i=1; i<intervals.size(); i++) {
			Interval newInterval = intervals.get(i);
			if (interval.end<newInterval.start) {
				results.add(interval);
				interval = newInterval;
			} else {
				interval = new Interval(interval.start, Math.max(interval.end, newInterval.end));
			}
		}
		results.add(interval);
		
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> results = new ArrayList<Interval>();
        
        if (intervals==null || intervals.isEmpty()) {
        	return results;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}     	
		});
        
        Interval newInterval = intervals.get(0);
        for (int i=1; i<intervals.size(); i++) {
        	Interval interval = intervals.get(i);
        	if (interval.end<newInterval.start) {
        		results.add(interval);
        	} else if (newInterval.end<interval.start) {
        		results.add(newInterval);
        		newInterval = interval;
        	} else if (interval.end>=newInterval.start||interval.start<=newInterval.end) {
        		newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
        	}       	
        }
        results.add(newInterval);
        return results;
    }
}
