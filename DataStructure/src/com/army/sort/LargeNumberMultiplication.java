package com.army.sort;

/**
 * 大数相乘
 * 
 * @author dai
 *
 */
public class LargeNumberMultiplication {

	public void largeNumberMultiplication(String num1, String num2) {
		char[] a1 = num1.toCharArray();
		char[] b1 = num2.toCharArray();

		startEndExchange(a1);
		startEndExchange(b1);
		multiplication(a1, b1);
	}

	private void multiplication(char[] a1, char[] b1) {
		int[] c = new int[a1.length + b1.length + 3];

		// 这是核心
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < b1.length; j++) {
				c[i + j] += Integer.parseInt(a1[i] + "") * Integer.parseInt(b1[j] + "");
			}
		}

		// 进位
		for (int i = 0; i < c.length - 1; i++) {
			int flag = c[i] / 10;
			c[i] %= 10;
			c[i + 1] += flag;
		}

		int m = c.length - 1;
		for (int i = c.length - 1; i >= 0; i--) {
			if (c[i] > 0) {
				break;
			}
			m--;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = m; i >= 0; i--) {
			sb.append(c[i]);
		}
		System.out.println("结果为：" + sb.toString());
	}

	private void startEndExchange(char[] num) {
		for (int i = 0; i < num.length / 2; i++) {
			num[i] += num[num.length - i - 1];
			num[num.length - i - 1] = (char) (num[i] - num[num.length - i - 1]);
			num[i] = (char) (num[i] - num[num.length - i - 1]);
		}
	}

	public static void main(String[] args) {
		LargeNumberMultiplication multiplication = new LargeNumberMultiplication();
		multiplication.largeNumberMultiplication("12", "21");
	}

}
