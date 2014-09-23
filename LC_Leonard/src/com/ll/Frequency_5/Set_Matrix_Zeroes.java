package com.ll.Frequency_5;

/**
 * 
 * @author Le
 *
 *         Given a m x n matrix, if an element is 0, set its entire row and
 *         column to 0. Do it in place.
 *
 */

public class Set_Matrix_Zeroes {

	// using O(m+n) is easy, to enable O(1), we have to use the space within the
	// matrix
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		if (m == 0) {
			return;
		}
		if (n == 0) {
			return;
		}

		boolean[] row_empty = new boolean[m];
		boolean[] col_empty = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row_empty[i] = true;
					col_empty[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row_empty[i] || col_empty[j]) {
					matrix[i][j] = 0;
				}
			}
		}

	}
}
