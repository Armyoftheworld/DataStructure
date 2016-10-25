package com.army.sort;

import java.util.Arrays;

public class InsertSort extends Sort {

	public void insertSort(int[] a) {
		int temp, j;
		System.out.println("原来的数组：" + Arrays.toString(a));
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			for (j = i - 1; j >= 0; j--) {
				if (a[j] > temp) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			if (a[j + 1] != temp) {
				a[j + 1] = temp;
			}
		}
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

	public static void main(String[] args) {
		InsertSort sort = new InsertSort();
		sort.insertSort(a);
	}

}
