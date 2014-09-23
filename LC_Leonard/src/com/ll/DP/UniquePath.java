package com.ll.DP;

public class UniquePath {
	
	
	/*
	 *  state: f[i][j]   paths from 0,0 -> i,j
	 *  function : f[i][j] = f[i - 1][j] + f[i][j - 1]	 
	 *  answer : f[n - 1][m - 1]
	 *
	 */
	public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }

	public int uniquePaths1(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[j] += res[j - 1];
			}
		}
		return res[n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid == null || m == 0 || n == 0)
			return 0;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					res[j] = 0;
				} else {
					if (j > 0)
						res[j] += res[j - 1];
				}
			}
		}
		return res[n - 1];
	}
}
