package com.ll.array_string;

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        return x == reverseNum(x);
    }
    private int reverseNum(int x){
        int result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
