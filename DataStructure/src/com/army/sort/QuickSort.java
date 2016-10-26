package com.army.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author dai
 *
 */
public class QuickSort extends Sort {

	public void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private int getPosition(int[] a, int left, int right) {
		int temp = a[left];
		while (left < right) {
			while (left < right && temp <= a[right]) {
				right--;
			}
			a[left] = a[right];
			while (left < right && temp >= a[left]) {
				left++;
			}
			a[right] = a[left];
		}
		a[left] = temp;
		return left;
	}

	private void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int position = getPosition(a, left, right);
			quickSort(a, left, position - 1);
			quickSort(a, position + 1, right);
		}
	}

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		System.out.println("原来的数组：" + Arrays.toString(a));
		sort.quickSort(a);
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

}
