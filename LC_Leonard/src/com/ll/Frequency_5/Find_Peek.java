package com.ll.Frequency_5;

public class Find_Peek {
	public static int findPeek(int[] A) {

		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return A[mid];
			} else if (A[mid] > A[mid - 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] a ={3,4,5,6,7,5,8,5,6,87,8,234,767,67,7,980,0,3}; 
		System.out.println(findPeek(a));
	}
}
