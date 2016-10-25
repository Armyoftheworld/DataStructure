package com.army.sort;

import java.util.Arrays;

public class BinaryInsertSort extends Sort {

	public void binaryInsertSort(int[] a) {
		int left, right, mid, temp;
		System.out.println("原来的数组：" + Arrays.toString(a));
		for (int i = 1; i < a.length; i++) {
			left = 0;
			right = i - 1;
			temp = a[i];
			while (left <= right) {
				mid = (left + right) / 2;
				if (a[i] > a[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			for (int j = i-1; j >=left; j--) {
				a[j + 1] = a[j];
			}
			if (a[left] != temp) {
				a[left] = temp;
			}
		}
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

	public static void main(String[] args) {
		BinaryInsertSort sort = new BinaryInsertSort();
		sort.binaryInsertSort(a);
	}

}
