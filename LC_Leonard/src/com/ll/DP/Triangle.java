package com.ll.DP;

import java.util.List;

/*
 * https://oj.leetcode.com/problems/triangle/
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	/***
    	 *  state : f[i][j] �� i,j ����ڵ㴥��, �ߵ���������ײ�, ���õ�����С��Ȩֵ֮��
    	 *  answer: f[0][0]
    	 *    ����     : f[i][j] = min(f[i + 1][j], f[i + 1][j + 1]) + t[i][j] //����һ��
    	 *       	f[i][j] = t[i][j]  //�ײ�
    	 */
    	
    	if (triangle.size() == 0){
    		return Integer.MAX_VALUE;
    	}
    	
    	//triangle.size() - 2   [������һ��]
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int val = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				triangle.get(i).set(j, val);
			}
		}
		return triangle.get(0).get(0);

    }
}
