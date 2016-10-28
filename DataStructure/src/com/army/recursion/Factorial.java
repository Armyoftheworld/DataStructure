package com.army.recursion;

/**
 * 阶乘
 * 
 * @author dai
 *
 */
public class Factorial {

	public int factorial(int n) {
		if (n == 1) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		int value = factorial.factorial(5);
		System.out.println("阶乘为：" + value);
	}

}
