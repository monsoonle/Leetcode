package com.ll.recursion;
import java.util.*;
/*
 * https://oj.leetcode.com/problems/combinations/
 */

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
	    if(n <= 0 || n < k){
	    	return res;
	    }
	    helper(n, k, 1, res, item);
	    return res;
	}
	private void helper(int n, int k, int start ,List<List<Integer>> res, List<Integer> item){
		if (item.size() == k){
			res.add(new ArrayList(item));
			return;
		}
		
		for (int i = start; i <= n; i++){
			item.add(i);
			helper(n, k, i+1, res, item);
			item.remove(item.size() - 1);
		}
		
	}
}
