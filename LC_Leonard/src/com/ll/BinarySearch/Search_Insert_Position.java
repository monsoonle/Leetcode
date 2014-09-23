package com.ll.BinarySearch;

/***
 * 
 * @author Le
 *
 *
 *         http://oj.leetcode.com/problems/search-insert-position/
 */

public class Search_Insert_Position {
	public int searchInsert(int[] A, int target) {
		if (A == null && A.length == 0) {
			return 0;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;

		if (A[0] > target) {
			return 0;
		}

		// find last number less than target, return (index + 1) if target was not found.

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (A[end] == target) {
			return end;
		}
		if (A[end] < target) {
			return end + 1;
		}

		if (A[start] == target) {
			return start;
		}

		return start + 1;
	}
}
