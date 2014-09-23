package com.ll.Frequency_5;

/***
 * 
 * @author Le
 *
 *
 *         Implement pow(x, n).
 * 
 * 
 */
public class Pow_x_n {
	public double pow(double x, int n) {
		if (n == 0){
			return 1.0;
		}
			
		if (n == 1){
			return x;
		}
			
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		double half = pow(x, n / 2);
		return half * half * pow(x, n % 2);
	}
}
