package com.ll.Frequency_5;
import java.util.*;

/**
 * 
 * @author Le
 *
 *         http://oj.leetcode.com/problems/merge-intervals/
 */


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Merge_Intervals {
	  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		  if (intervals == null || intervals.size() <= 1) {
	            return intervals;
	        }
	      ArrayList<Interval> rst = new ArrayList<Interval>();
	      //sort Intervals
	      Collections.sort(intervals, new IntervalComparator());
	      
	      //±éÀú
	      Interval last = intervals.get(0);
	      for (int i = 1; i < intervals.size(); i++) {
	    	  Interval current = intervals.get(i);
	    	  //there is overlap part
	    	  if (current.start <= last.end){
	    		last.end = Math.max(current.end, last.end);  
	    	  }else{
	    		  //there is no overlap here, add to rst
	    		  rst.add(last);
	    		  //current node becomes last node
	    		  last = current;
	    	  }
	    	  
	      }
	      rst.add(last);
		  return rst;
	    }
	  
	    private class IntervalComparator implements Comparator<Interval> {
	        public int compare(Interval a, Interval b) {
	            return a.start - b.start;
	        }
	    }
}


