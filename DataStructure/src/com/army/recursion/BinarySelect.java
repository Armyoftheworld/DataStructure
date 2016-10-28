package com.army.recursion;

import java.util.Arrays;

import com.army.sort.BasicSort;
import com.army.sort.Sort;

/**
 * 二分查找法
 * 
 * @author dai
 *
 */
public class BinarySelect extends Sort {

	public static void main(String[] args) {
		BasicSort sort = new BasicSort();
		sort.basicSort(a);
		BinarySelect select = new BinarySelect();
		System.out.println("排序的数组：" + Arrays.toString(a));
		int index = select.unRecursionSelect(a, 24);
		System.out.println("index = " + index);
	}

	// 递归查找
	public int recursionSelect(int[] a, int value, int left, int right) {
		if (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] < value) {
				return recursionSelect(a, value, mid + 1, right);
			} else if (a[mid] > value) {
				return recursionSelect(a, value, left, mid - 1);
			} else {
				return mid;
			}
		}
		return -1;
	}

	// 非递归查找
	public int unRecursionSelect(int[] a, int value) {
		int left = 0;
		int right = a.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (a[mid] > value) {
				right = mid - 1;
			} else if (a[mid] < value) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
