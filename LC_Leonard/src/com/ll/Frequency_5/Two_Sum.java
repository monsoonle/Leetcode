package com.ll.Frequency_5;

import java.util.*;

/***
 * 
 * @author Le
 * 
 *         Given an array of integers, find two numbers such that they add up to
 *         a specific target number.
 * 
 *         The function twoSum should return indices of the two numbers such
 *         that they add up to the target, where index1 must be less than
 *         index2. Please note that your returned answers (both index1 and
 *         index2) are not zero-based.
 * 
 *         You may assume that each input would have exactly one solution.
 * 
 *         Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

public class Two_Sum {

	public static int[] twoSum(int[] numbers, int target) {
		int[] rst = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				// (both index1 an index2) are not zero-based.
				rst[0] = index + 1;
				rst[1] = i + 1;
			} else {
				map.put(target - numbers[i], i);
			}
		}

		return rst;
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int[] rst = twoSum(numbers, 17);
		System.out.println(rst[0] + ", " + rst[1]);

	}
}
