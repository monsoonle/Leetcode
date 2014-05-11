package com.ll.Frequency_5;

import java.util.Stack;

public class Valid_Parentheses {
	public boolean isValid(String s) {
		
		if(s == null || s.length() <= 1){
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>(); 
		
		for(Character c : s.toCharArray()){
			if("({[".contains(String.valueOf(c))){
				stack.push(c);
			}else{
				if(!stack.isEmpty() && isPair(stack.peek(), c)){
					stack.pop();
				}else{
					return false;
				}
			}
		}

		return stack.isEmpty();

	}
	
	private boolean isPair(char c1, char c2){
		
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') ;
	}
	
}
