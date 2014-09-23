package com.ll.DP;

public class Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len <= 1) {
			return s;
		}

		int start = 0, maxLen = 0;
		int left, right;
		for (int i = 1; i < len; i++) {
			// <----- i-1, i------->
			left = i - 1;
			right = i;
			while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			if (right - left - 1 > maxLen){
				maxLen = right - left -1;
				start = left + 1;
			}

			// <----- i-1, i, i + 1 ------->
			left = i - 1;
			right = i + 1;
			while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			if (right - left - 1 > maxLen){
				maxLen = right - left - 1;
				start = left + 1;
			}
		}
		return s.substring(start, start + maxLen);
	}
}
