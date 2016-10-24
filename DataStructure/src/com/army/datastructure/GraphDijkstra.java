package com.army.datastructure;

import java.util.Arrays;

public class GraphDijkstra {
	public int MAX = 65535;
	public int[][] graph;

	public GraphDijkstra() {
		graph = initGraph();
	}

	public void dijkstra(int[][] graph) {
		int[] dis = new int[graph.length];// 记录的是v0到每个顶点的最短路径
		boolean[] isgetPath = new boolean[graph.length];
		int min, k = 0;
		for (int i = 0; i < graph.length; i++) {
			dis[i] = graph[0][i];
		}
		dis[0] = 0;
		isgetPath[0] = true;
		for (int i = 1; i < graph.length; i++) {
			min = MAX;
			for (int j = 0; j < graph.length; j++) {
				if (!isgetPath[j] && dis[j] < min) {
					min = dis[j];
					k = j;
				}
			}
			isgetPath[k] = true;
			for (int j = 0; j < graph.length; j++) {
				if (!isgetPath[j] && min + graph[k][j] < dis[j]) {
					dis[j] = min + graph[k][j];
				}
			}
		}
		System.out.println(Arrays.toString(dis));
	}

	public static void main(String[] args) {
		GraphDijkstra graphDijkstra = new GraphDijkstra();
		graphDijkstra.dijkstra(graphDijkstra.graph);
	}

	private int[][] initGraph() {
		int[][] graph = new int[9][9];
		graph[0] = new int[] { 0, 1, 5, MAX, MAX, MAX, MAX, MAX, MAX };
		graph[1] = new int[] { 1, 0, 3, 7, 5, MAX, MAX, MAX, MAX };
		graph[2] = new int[] { 5, 3, 0, MAX, 1, 7, MAX, MAX, MAX };
		graph[3] = new int[] { MAX, 7, MAX, 0, 2, MAX, 3, MAX, MAX };
		graph[4] = new int[] { MAX, 5, 1, 2, 0, 3, 6, 9, MAX };
		graph[5] = new int[] { MAX, MAX, 7, MAX, 3, 0, MAX, 5, MAX };
		graph[6] = new int[] { MAX, MAX, MAX, 3, 6, MAX, 0, 2, 7 };
		graph[7] = new int[] { MAX, MAX, MAX, MAX, 9, 5, 2, 0, 4 };
		graph[8] = new int[] { MAX, MAX, MAX, MAX, MAX, MAX, 7, 4, 0 };
		return graph;
	}

}
