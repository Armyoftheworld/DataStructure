package com.army.greedy;

import java.util.Arrays;

/**
 * 贪心算法<br>
 * 此算法求出的不一定是最优解，是局部最优解<br>
 * 
 * @author Army
 *
 */
public class GreedyAlgorithm {

	public int[] weight = { 10, 60, 30, 15, 45, 5 };
	public int[] value = { 34, 23, 54, 22, 62, 13 };
	public int MAXWEIGHT = 100;

	public void greedy(int[] weight, int[] value, int max) {
		double[] valuePreWieght = new double[weight.length];
		int[] index = new int[weight.length];
		int remain = max;
		for (int i = 0; i < weight.length; i++) {
			valuePreWieght[i] = value[i] * 1.0 / weight[i];
			index[i] = i;
		}
		System.out.println("性价比：" + Arrays.toString(valuePreWieght));
		for (int i = 1; i < valuePreWieght.length; i++) {
			for (int j = 0; j < valuePreWieght.length - i; j++) {
				if (valuePreWieght[j] < valuePreWieght[j + 1]) {
					double temp = valuePreWieght[j];
					valuePreWieght[j] = valuePreWieght[j + 1];
					valuePreWieght[j + 1] = temp;

					int flag = index[j];
					index[j] = index[j + 1];
					index[j + 1] = flag;
				}
			}
		}
		int total = 0;
		for (int i = 0; i < weight.length; i++) {
			int w = weight[index[i]];
			if (w <= remain) {
				System.out.println("把重量为" + w + "的装进去");
				remain -= w;
				total += w;
			}
		}
		System.out.println("total == " + total);

	}

	public static void main(String[] args) {
		GreedyAlgorithm algorithm = new GreedyAlgorithm();
		algorithm.greedy(algorithm.weight, algorithm.value, algorithm.MAXWEIGHT);
	}

}
