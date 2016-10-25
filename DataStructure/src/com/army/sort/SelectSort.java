package com.army.sort;

import java.util.Arrays;

public class SelectSort extends Sort {

	public void selectSort(int[] a) {
		System.out.println("原来的数组：" + Arrays.toString(a));
		int min, k = 0;
		for (int i = 0; i < a.length; i++) {
			min = a[i];
			k = i;
			for (int j = i + 1; j < a.length; j++) {
				if (min > a[j]) {
					min = a[j];
					k = j;
				}
			}
			if (k != i) {
				a[k] = a[i];
				a[i] = min;
			}
		}
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

	public static void main(String[] args) {
		SelectSort sort = new SelectSort();
		sort.selectSort(a);
	}

}
