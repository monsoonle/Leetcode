package com.ll.Frequency_5;

import java.util.*;

/***
 * 
 * 
 * @author Le
 *
 *
 *         Given an array S of n integers, are there elements a, b, c in S such
 *         that a + b + c = 0? Find all unique triplets in the array which gives
 *         the sum of zero. Note: Elements in a triplet (a,b,c) must be in
 *         non-descending order. (ie, a ¡Ü b ¡Ü c) The solution set must not
 *         contain duplicate triplets. For example, given array S = {-1 0 1 2 -1
 *         -4}, A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
public class Three_Sum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		// boundary detection
		if (num == null || num.length < 3) {
			return results;
		}

		// Need to sort array to complete  pretreatment.
		Arrays.sort(num); 

		for (int i = 0; i <= num.length - 2; i++) {
			// The solution set must not contain duplicate triplets.
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			int start = i + 1;
			int end = num.length - 1;

			// 2 pointers start --> <-- end
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum == 0) {
					ArrayList<Integer> triplet = new ArrayList<Integer>();
					triplet.add(num[i]);
					triplet.add(num[start]);
					triplet.add(num[end]);
					results.add(triplet);
					// Keep searching
					start++;
					end--;
					//void duplicate element
					while (start < end && num[start] == num[start - 1]) {
						start++;
					}
					while (start < end && num[end] == num[end + 1]) {
						end--;
					}
				} else if (sum < 0) {
					start++;   //sum is less than 0 , then find a larger number to replace.
				} else {
					end--;	//sum is greater than 0 , then find a smaller number to replace.
				}

			}

		}

		return results;
	}

}
