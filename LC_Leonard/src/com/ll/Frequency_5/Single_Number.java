package com.ll.Frequency_5;
/**
 * 
 * @author Le
 * 
 *         Single Number http://oj.leetcode.com/problems/single-number/ 
 *         Single Number II http://oj.leetcode.com/problems/single-number-ii/
 *
 */
public class Single_Number {
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int rst = A[0];
		for (int i = 1; i < A.length; i++) {
			rst ^= A[i];
		}
		return rst;
	}

	public int singleNumber_II_A(int[] A) {
		int[] digits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				digits[i] += (A[j] >> i) & 1;
			}
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += (digits[i] % 3) << i;
		}
		return res;
	}

	public int singleNumber_II_B(int[] A) {
		
//        int one = 0, two = 0;
//        for(int i = 0; i < A.length; ++i) {
//            two |= (one & A[i]);
//            one ^= A[i];
//            // if a number shows 3 times, set bit to 0
//            int carry = one & two;
//            two -= carry;
//            one -= carry;
//        }
//        return one;
//       解法就是每位用两个二进制位计数，到 3 就清零，唯一 trick 是 a + b 的进位是 a^b
		
		int one = 0, two = 0;
		for (int i = 0; i < A.length; ++i) {
			int carry = one & A[i];
            one ^= A[i];
            two ^= carry;
            int tmp = ~(one & two);
            one &= tmp;
            two &= tmp;
		}
		return one ^ two;
	}

}
