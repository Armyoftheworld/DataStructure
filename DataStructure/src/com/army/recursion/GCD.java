package com.army.recursion;

/**
 * 欧几里得算法，两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数
 * 
 * @author dai
 *
 */
public class GCD {

	public int gcd(int max, int min) {
		if (max % min == 0) {
			return min;
		} else {
			return gcd(min, max % min);
		}
	}

	public static void main(String[] args) {
		GCD gcd = new GCD();
		int m = gcd.gcd(3, 2);
		System.out.println("最大公约数是" + m);
	}

}
