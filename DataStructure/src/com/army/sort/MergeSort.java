package com.army.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 
 * @author dai
 *
 */
public class MergeSort extends Sort {

	public void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	private void merge(int[] a, int left, int mid, int right) {
		int[] tempArr = new int[a.length];
		int rightStart = mid + 1;
		int third = left;
		int tmp = left;
		while (left <= mid && rightStart <= right) {// 填充数组，这时候可能出现某一边数组的值已经全部填充进去了，另一个还有值没填充
			if (a[left] < a[rightStart]) {
				tempArr[third++] = a[left++];
			} else {
				tempArr[third++] = a[rightStart++];
			}
		}
		// 左边的数组还有数据没有填充进去tmpArray
		while (left <= mid) {
			tempArr[third++] = a[left++];
		}
		// 右边的数组还有数据没有填充进去tmpArray
		while (rightStart <= right) {
			tempArr[third++] = a[rightStart++];
		}
		while (tmp <= right) {
			a[tmp] = tempArr[tmp];
			tmp++;
		}
	}

	public static void main(String[] args) {
		System.out.println("原来的数组：" + Arrays.toString(a));
		MergeSort sort = new MergeSort();
		sort.mergeSort(a, 0, a.length - 1);
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

}
