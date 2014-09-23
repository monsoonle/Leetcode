package com.ll.array_string;

import java.util.*;

/***
 * 
 * @author Le
 *
 *         https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class Longest_Substring_Without_Repeating_Characters {
	
	/**
	 * 
	 * @param s
	 *            我们介绍一种线性的算法，也是这类题目最常见的方法。基本思路是维护一个窗口，每次关注窗口中的字符串，在每次判断中，
	 *            左窗口和右窗口选择其一向前移动。同样是维护一个 HashSet,
	 *            正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，如果发现重复字符
	 *            ，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果
	 *            ，此时移动左窗口，直到不再有重复字符为止，中间跳过的这些串中不会有更好的结果
	 *            ，因为他们不是重复就是更短。因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍，因此时间复杂度为
	 *            O(2*n)=O(n), 是线性算法。空间复杂度为 HashSet 的 size, 也是 O(n)
	 */
	
	public int lengthOfLongestSubstring(String s) {
		if (s == null && s.length() == 0) {
			return 0;
		}
		HashSet<Character> set = new HashSet<Character>();
		int max = 0;
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			if (set.contains(s.charAt(right))) {
				if (max < right - left) {
					max = right - left;
				}
				while (s.charAt(left) != s.charAt(right)) {
					set.remove(s.charAt(left));
					left++;
				}
				left++;
			} else {
				set.add(s.charAt(right));
			}
			right++;
		}
		max = Math.max(max, right - left);
		return max;
	}
}
