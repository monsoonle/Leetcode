package com.ll.DP;

public class Unique_Binary_Search_Trees {
	public static int numTrees(int n) {
		if (n < 0){
			return 0;
		}
		
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		
		for (int i = 2; i <= n; i++){
			for (int j = 0; j < i; j ++){
				count[i] += count[j] * count[i - j - 1];
			}
		}
		return count[n];
	}
	
	public static void main(String[] args) {
		int val = numTrees(2);
		System.out.println("result :" + val);
	}
}
