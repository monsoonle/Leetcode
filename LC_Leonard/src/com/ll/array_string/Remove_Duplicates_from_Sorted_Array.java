package com.ll.array_string;

public class Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int size = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != A[size]) {
				size++;
				A[size] = A[i];
			}
		}
		// 0 base
		return size + 1;
	}

	public int removeDuplicates2(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int index = 0;
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[index]) {
				index++;
				A[index] = A[i];
				count = 1;
			} else if (count < 2) {
				index++;
				A[index] = A[i];
				count++;
			}
		}
		return index + 1;
	}
}
