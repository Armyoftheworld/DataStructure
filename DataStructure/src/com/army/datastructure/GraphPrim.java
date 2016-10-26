package com.army.datastructure;

/**
 * 最小生成树：普里姆算法
 * @author dai
 *
 */
public class GraphPrim {
	public int MAX = 65535;
	private int[][] graph;

	public GraphPrim() {
		graph = initGraph();
	}

	public void prim() {
		int[] adjvex = new int[graph.length];// 存放最小生成树的顶点
		int[] lowcast = new int[graph.length];// 存放最小权重
		adjvex[0] = 0;
		lowcast[0] = 0;
		int min = 0;
		int sum = 0;
		int k = 0;

		for (int i = 1; i < graph.length; i++) {
			lowcast[i] = graph[0][i];
		}

		for (int i = 1; i < graph.length; i++) {
			min = MAX;

			for (int j = 1; j < lowcast.length; j++) {
				if (lowcast[j] != 0 && lowcast[j] != MAX && lowcast[j] < min) {
					min = lowcast[j];
					k = j;
				}
			}
			System.out.println("----------------------------------------------");
			for(int j=0;j<lowcast.length;j++){
				System.out.print(lowcast[j]+"\t");
			}
			lowcast[k] = 0;
			System.out.println();
			System.out.println("顶点" + k + "到顶点" + adjvex[k] + "的权重:" + min);
			sum += min;
			for (int j = 1; j < graph[i].length; j++) {
				int weigth = graph[k][j];
				if (weigth != 0 && weigth != MAX && weigth < lowcast[j]) {
					lowcast[j] = weigth;
					adjvex[j] = k;
				}
			}
			for(int j=0;j<lowcast.length;j++){
				System.out.print(lowcast[j]+"\t");
			}
			System.out.println();
		}
		System.out.println("最小权值为"+sum);
//		for(int j=0;j<adjvex.length;j++){
//			System.out.println("j=="+j+"\tadjvex[j]=="+adjvex[j]);
//		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphPrim graph = new GraphPrim();
		graph.prim();

	}

	private int[][] initGraph() {
		int[][] graph = new int[9][9];
		graph[0] = new int[] { 0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX };
		graph[1] = new int[] { 10, 0, 18, MAX, MAX, MAX, 16, MAX, 12 };
		graph[2] = new int[] { MAX, 18, 0, 22, MAX, MAX, MAX, MAX, 8 };
		graph[3] = new int[] { MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21 };
		graph[4] = new int[] { MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX };
		graph[5] = new int[] { 11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX };
		graph[6] = new int[] { MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX };
		graph[7] = new int[] { MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX };
		graph[8] = new int[] { MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0 };
		return graph;
	}

}
