package com.army.sort;

import java.util.Arrays;

public class ShellSort extends Sort {

	public void shellSort(int[] a) {
		int delta = a.length, temp;
		System.out.println("原来的数组：" + Arrays.toString(a));
		while (true) {
			delta = delta / 2;
			for (int i = 0; i < a.length / delta; i++) {
				for (int j = i; j + delta < a.length; j += delta) {
					for (int k = i; k + delta < a.length; k += delta) {
						if (a[k] > a[k + delta]) {
							temp = a[k];
							a[k] = a[k + delta];
							a[k + delta] = temp;
						}
					}
				}
			}
			if (delta == 1) {
				break;
			}
		}
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

	public static void main(String[] args) {
		ShellSort sort = new ShellSort();
		sort.shellSort(a);
	}

}
