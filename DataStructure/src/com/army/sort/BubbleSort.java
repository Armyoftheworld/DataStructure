package com.army.sort;

import java.util.Arrays;

public class BubbleSort extends Sort {

	public void bubbleSort(int[] a) {
		int temp = 0;
		System.out.println("原来的数组：" + Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(a);

	}

}
