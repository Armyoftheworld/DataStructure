package com.army.dynamic_programming;

/**
 * 动态规划法：求最大子序列长度<br>
 * 原理：<br>
 * C[i,j] = C[i-1,j-1]+1, (Xi=Xj,i>0,j>0)<br>
 * C[i,j] = MAX(C[i-1,j],C[i,j-1]),(Xi!=Xj,i>0,j>0)<br>
 * 
 * @author dai
 *
 */
public class MaxSubsequenceLength {

	public int getMaxSubsequence(String A, String B) {
		StringBuilder sb = new StringBuilder();
		int m = A.length();// 表示行
		int n = B.length();// 表示列
		int[][] arr = new int[m][n];
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		for (int i = 0; i < m; i++) {// 把第一列初始化
			if (b[0] == a[i]) {
				for (int j = i; j < m; j++) {
					arr[j][0] = 1;
				}
				break;
			}
		}
		for (int i = 0; i < n; i++) {// 把第一行初始化
			if (a[0] == b[i]) {
				for (int j = i; j < n; j++) {
					arr[0][j] = 1;
				}
				break;
			}
		}
		for (int i = 1; i < m; i++) {// 用注释里的规律赋值
			for (int j = 1; j < n; j++) {
				if (a[i] == b[j]) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		//根据最后一列或者最后一行就能找出最大子序列
		int last = arr[0].length - 1;
		int flag = arr[0][last];
		if (flag == 1) {
			sb.append(a[0]);
		}
		for (int i = 1; i < m; i++) {
			if (flag != arr[i][last]) {
				sb.append(a[i]);
				flag = arr[i][last];
			}
		}
		System.out.println("最大子序列：" + sb.toString());
		return arr[m - 1][n - 1];
	}

	public static void main(String[] args) {
		MaxSubsequenceLength length = new MaxSubsequenceLength();
		int len = length.getMaxSubsequence("android", "random");
		System.out.println("最大子序列长度：" + len);
	}

}
