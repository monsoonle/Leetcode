package com.ll.Frequency_5;

public class Factorial {

//	public static int Factorial(int n) {
//		/*
//		 * n > 0 f(n) = n * (n - 1)!
//		 *  n = 0 f(n) = 1
//		 *   A[n] = n!
//		 */
//		int[] A = new int[n + 1];
//		A[0] = 1;
//		for (int i = 1; i <= n; i++) {
//			A[i] = i * A[i - 1];
//		}
//
//		return A[n];
//
//	}
	
	public static int Factorial(int n) {

		int result = 1; // result = (n - 1)!  n > 0
		if (n < 0) {
			return result;  
		}	
		for (int i = 1; i <= n; i++) {
			result = i * result;
		}

		return result;

	}

	public static void main(String[] args) {
		System.out.println(Factorial(10));
	}

}
