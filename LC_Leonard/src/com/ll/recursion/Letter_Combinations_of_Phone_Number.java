package com.ll.recursion;

import java.util.*;

public class Letter_Combinations_of_Phone_Number {
	private String getLetters(char digit) {
		switch (digit) {
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		default:
			return "";
		}
	}

	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();
		result.add("");
		if (digits == null || digits.length() == 0) {
			return result;
		}

		for (int i = 0; i < digits.length(); i++) {
			String letters = getLetters(digits.charAt(i));
			ArrayList<String> combo = new ArrayList<String>();
			for (int j = 0; j < result.size(); j++) {
				for (int k = 0; k < letters.length(); k++) {
					combo.add(result.get(j)
							+ Character.toString(letters.charAt(k)));
				}
			}
			result = combo;
		}
		return result;

	}
}
