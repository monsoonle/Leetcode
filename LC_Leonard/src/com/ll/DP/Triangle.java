package com.ll.DP;

import java.util.List;

/*
 * https://oj.leetcode.com/problems/triangle/
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	/***
    	 *  state : f[i][j] 从 i,j 这个节点触发, 走到三角形最底层, 所得到的最小的权值之和
    	 *  answer: f[0][0]
    	 *    方程     : f[i][j] = min(f[i + 1][j], f[i + 1][j + 1]) + t[i][j] //有下一层
    	 *       	f[i][j] = t[i][j]  //底层
    	 */
    	
    	if (triangle.size() == 0){
    		return Integer.MAX_VALUE;
    	}
    	
    	//triangle.size() - 2   [倒数第一层]
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int val = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				triangle.get(i).set(j, val);
			}
		}
		return triangle.get(0).get(0);

    }
}
