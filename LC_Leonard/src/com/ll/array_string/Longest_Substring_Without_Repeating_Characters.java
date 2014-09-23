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
	 *            ���ǽ���һ�����Ե��㷨��Ҳ��������Ŀ����ķ���������˼·��ά��һ�����ڣ�ÿ�ι�ע�����е��ַ�������ÿ���ж��У�
	 *            �󴰿ں��Ҵ���ѡ����һ��ǰ�ƶ���ͬ����ά��һ�� HashSet,
	 *            ����������ƶ��Ҵ��ڣ����û�г����ظ�������ƶ��Ҵ��ڣ���������ظ��ַ�
	 *            ����˵����ǰ�����еĴ��Ѿ�������Ҫ�󣬼����ƶ��д��ڲ����ܵõ����õĽ��
	 *            ����ʱ�ƶ��󴰿ڣ�ֱ���������ظ��ַ�Ϊֹ���м���������Щ���в����и��õĽ��
	 *            ����Ϊ���ǲ����ظ����Ǹ��̡���Ϊ�󴰿ں��Ҵ��ڶ�ֻ��ǰ�������������ڶ���ÿ��Ԫ�ط��ʲ�����һ�飬���ʱ�临�Ӷ�Ϊ
	 *            O(2*n)=O(n), �������㷨���ռ临�Ӷ�Ϊ HashSet �� size, Ҳ�� O(n)
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
