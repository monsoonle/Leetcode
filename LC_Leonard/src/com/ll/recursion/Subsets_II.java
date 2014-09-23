package com.ll.recursion;

import java.util.*;

/***
 * 
 * @author Le
 *
 *         Given a collection of integers that might contain duplicates, S,
 *         return all possible subsets.
 * 
 *         Note: Elements in a subset must be in non-descending order. The
 *         solution set must not contain duplicate subsets. For example, If S =
 *         [1,2,2], a solution is:
 * 
 *         [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 *
 */

public class Subsets_II {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		if (num == null || num.length == 0) {
			return rst;
		}
		Arrays.sort(num);
		subsetHelper(rst, tmp, num, 0);

		return rst;
	}

	private void subsetHelper(ArrayList<ArrayList<Integer>> rst,
			ArrayList<Integer> tmp, int[] num, int pos) {

		rst.add(new ArrayList<Integer>(tmp));

		for (int i = pos; i < num.length; i++) {
			if (i > 0 && i != pos && num[i] == num[i - 1]) {
				continue;
			}

			tmp.add(num[i]);
			subsetHelper(rst, tmp, num, i + 1);
			tmp.remove(tmp.size() - 1);
		}

	}

}
