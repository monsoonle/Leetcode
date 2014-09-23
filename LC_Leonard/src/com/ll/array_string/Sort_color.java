package com.ll.array_string;

public class Sort_color {
	public static void sortColors(int[] A) {
		if (A == null || A.length == 0)
			return;
		int idx0 = 0;
		int idx1 = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				A[i] = 2;
				A[idx1++] = 1;
				A[idx0++] = 0;
			} else if (A[i] == 1) {
				A[i] = 2;
				A[idx1++] = 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 0, 2, 1, 0 };
		sortColors(A);
		for (int i : A) {
			System.out.print(i+ " ");
		}
	}
}
