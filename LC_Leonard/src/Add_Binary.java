/*
 *  https://oj.leetcode.com/problems/add-binary/
 */
public class Add_Binary {
	public String addBinary(String a, String b) {

		StringBuilder result = new StringBuilder();
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}

		int carry = 0;
		int len1 = a.length(), len2 = b.length();
		for (int i = 0; i < len1; i++) {
			int achar = a.charAt(len1 - 1 - i) - '0';
			int bchar = i > len2 - 1 ? 0 : b.charAt(len2 - 1 - i) - '0';
			int digit = (achar + bchar + carry) % 2;
			result.append(digit);
			carry = (achar + bchar + carry) / 2;
		}
		if (carry != 0) {
			result.append(carry);
		}

		return result.reverse().toString();
	}
}
