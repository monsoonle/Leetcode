package com.ll.recursion;

import java.util.*;

public class Combination_Sum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(candidates, 0, target, list, res);
		return res;
	}

	private void helper(int[] candidates, int start, int target, ArrayList<Integer> item, List<List<Integer>> res) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1])
				continue;
			item.add(candidates[i]);
			helper(candidates, i, target - candidates[i], item, res);
			item.remove(item.size() - 1);
		}
	}
	
	/*
	 * Combination_Sum II
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		helper2(candidates, 0, target, new ArrayList<Integer>(), res);
		return res;
	}

	private void helper2(int[] candidates, int start, int target, ArrayList<Integer> item, List<List<Integer>> res) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			item.add(candidates[i]);
			helper2(candidates, i + 1, target - candidates[i], item, res);
			item.remove(item.size() - 1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
