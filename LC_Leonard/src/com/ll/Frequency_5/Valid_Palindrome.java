package com.ll.Frequency_5;

/***
 * 
 * @author Le
 *
 *         Given a string, determine if it is a palindrome, considering only
 *         alphanumeric characters and ignoring cases.
 * 
 *         For example, "A man, a plan, a canal: Panama" is a palindrome.
 *         "race a car" is not a palindrome.
 */
public class Valid_Palindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		// two pointer
		int front = 0;
		int end = s.length() - 1;

		// front ---> <--- end

		while (front < end) {
			while(front < s.length() && !isvalid(s.charAt(front))){
				front++;
			}
			
			if (front == s.length()) { // for emtpy string ¡°.,,,¡±     
                return true; 
            }     
			
			while(end >= 0 && !isvalid(s.charAt(end))){
				end--;
			}
			
			if(Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))){
				return false;
			}else{
				front++;
				end--;
			}

		}
		
		return (end <= front);

	}

	private boolean isvalid(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}
}
