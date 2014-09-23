/*
 * https://oj.leetcode.com/problems/word-search/
 */

public class Word_Search {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0) {
			return true;
		}
		int m = board.length, n = board[0].length;
		if (m == 0 || n == 0) {
			return false;
		}
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (find(board, word, i, j, 0, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean find(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
		int m = board.length, n = board[0].length;
		if (index == word.length()) {
			return true;
		}
		if (i < 0 || i >= m || j < 0 || j >= n
			|| board[i][j] != word.charAt(index) || visited[i][j]) {
			return false;
		}
		visited[i][j] = true;
		boolean result = find(board, word, i, j + 1, index + 1, visited)
				|| find(board, word, i, j - 1, index + 1, visited)
				|| find(board, word, i + 1, j, index + 1, visited)
				|| find(board, word, i - 1, j, index + 1, visited);
		visited[i][j] = false;
		return result;

	}
}
