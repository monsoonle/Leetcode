package com.ll.array_string;

//如果 A 或者 B 为空，则直接返回 B[k-1] 或者 A[k-1]；
//如果 k 为 1，我们只需要返回 A[0] 和 B[0] 中的较小值；
//如果 A[k/2-1]=B[k/2-1]，返回其中一个；

public class Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if (len % 2 == 0) {
			return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
		} else {
			return findKth(A, 0, B, 0, len / 2 + 1);
		}

	}


	private double findKth(int A[], int A_start, int B[], int B_start,
			int k) {
		if (A_start >= A.length){
			return B[B_start + k - 1];
		}
		if (B_start >= B.length){
			return A[A_start + k - 1];
		}
		
		if (k == 1){
			return Math.min(A[A_start], B[B_start]);
		}
		
		int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
		
		if (A_key < B_key) {
			// A[A_start + k / 2 - 1] 左边的数全部舍弃, 必定小于kth number
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
}
