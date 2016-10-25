package com.army.sort;

import java.util.Arrays;

public class HeapSort extends Sort {

	/**
	 * 用二叉树这种结构，先建立一个大堆（堆：父节点肯定比左右节点大，根节点最大），然后依次把堆的根节点弹出去
	 * 如果父节点的下标是i，那左节点的下标2*i+1，右结点的下标2*i+2
	 * 
	 * @param a
	 */
	public void heapSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		System.out.println("原来的数组：" + Arrays.toString(a));
		buildMaxHeap(a);
		for (int i = a.length - 1; i > 0; i--) {
			exchangeElements(a, 0, i);
			maxHeap(a, i, 0);
		}
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

	private void buildMaxHeap(int[] a) {
		int height = (a.length - 1) / 2;// 根据二叉树的结构，只需要一半，就能查出后一半
		for (int i = height; i >= 0; i--) {
			maxHeap(a, a.length, i);
		}
	}

	private void maxHeap(int[] a, int length, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = a[i];
		int maxIndex = i;
		if (left < length && a[left] > max) {
			max = a[left];
			maxIndex = left;
		}
		if (right < length && a[right] > max) {
			max = a[right];
			maxIndex = right;
		}
		if (maxIndex != i) {
			exchangeElements(a, maxIndex, i);
			maxHeap(a, length, maxIndex);
		}

	}

	private void exchangeElements(int[] a, int maxIndex, int i) {
		int temp = a[maxIndex];
		a[maxIndex] = a[i];
		a[i] = temp;
	}

	public static void main(String[] args) {
		HeapSort sort = new HeapSort();
		sort.heapSort(a);
	}

}
