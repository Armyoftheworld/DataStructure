package com.army.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicSort extends Sort {

	public void basicSort(int[] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int max = 0;
		for (int a : arr) {
			if (a > max) {
				max = a;
			}
		}
		int time = 0;
		while (max > 1) {
			max = max / 10;
			time++;
		}
		for (int i = 0; i < 10; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < time; i++) {
			for (int j = 0; j < arr.length; j++) {
				int index = (arr[j] % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);
				list.get(index).add(arr[j]);
			}
			int k = 0;
			for (int j = 0; j < list.size(); j++) {
				while (!list.get(j).isEmpty()) {
					arr[k++] = list.get(j).get(0);
					list.get(j).remove(0);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("原来的数组：" + Arrays.toString(a));
		BasicSort sort = new BasicSort();
		sort.basicSort(a);
		System.out.println("排序的数组：" + Arrays.toString(a));
	}

}
