package com.ll.Frequency_5;

/***
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 */

public class String_to_Integer {
	public static int atoi(String str) {
		//initiation
		double result = 0;
		if(str == null || str.length() < 1){
			return 0;
		}
		
		//space
		str = str.trim();
		// +/-
		char sign = '+'; //by default
		if(str.charAt(0) == '-'){
			sign = '-';
		}
		//Traversal
		int i = 1;
		while(str.length() > i &&str.charAt(i) >= '0' && str.charAt(i) <= '9'){
			result = result*10 + (str.charAt(i) - '0');
			i++;
		}
		
		if(sign == '-'){
			result = -result;
		}
		
		
		// max / min Integer
		if(result < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		if(result > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		
		
		return (int)result;
	}
	

}
