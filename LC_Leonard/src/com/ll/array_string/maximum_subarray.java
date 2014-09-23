package com.ll.array_string;

/*
 * http://oj.leetcode.com/problems/maximum-subarray/ 
 */
public class maximum_subarray {
	//滑动窗口, 若和为负数, 舍弃前端所有子串
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
