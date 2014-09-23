package com.ll.recursion;

import java.util.ArrayList;

/***
 * 
 * @author Le
 * 
 *         Given a collection of numbers, return all possible permutations.
 * 
 *         For example, [1,2,3] have the following permutations: [1,2,3],
 *         [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();

		if (num == null || num.length == 0) {
			return rst;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(rst, list, num, 0);
		return rst;
	}

	private void helper(ArrayList<ArrayList<Integer>> rst,
			ArrayList<Integer> list, int[] num, int pos) {
		// same element number as num.length, then it will be an answer
		if (list.size() == num.length) {
			rst.add(new ArrayList<Integer>(list));
		}

		for (int i = 0; i < num.length; i++) {
			if (list.contains(num[i])) {
				continue;
			}

			list.add(num[i]);
			helper(rst, list, num, i + 1);
			list.remove(list.size() - 1);
		}

	}

}
