package com.ll.recursion;

import java.util.*;

public class Palindrome_Partitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null) {
			return result;
		}
		helper(s, 0, result, new ArrayList<String>());
		return result;

	}

	private boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}

			start++;
			end--;
		}
		return true;

	}

	private void helper(String s, int postion, List<List<String>> result,
			ArrayList<String> path) {
		if (postion == s.length()) {
			result.add(new ArrayList(path));
			return;
		}
		for (int i = postion + 1; i <= s.length(); i++) {
			String prefix = s.substring(postion, i);
			if (!isPalindrome(prefix)) {
				continue;
			}
			path.add(prefix);
			helper(s, i, result, path);
			path.remove(path.size() - 1);
		}
	}
}
