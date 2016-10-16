package com.army.datastructure;

import java.util.LinkedList;

public class Graph {
	public static int MAX = 65535;
	private boolean isVisit[];
	private int[][] graph;

	public Graph() {
		graph = initGraph();
		isVisit = new boolean[graph.length];
	}

	private int getNeighbor(int index) {
		int nei = -1;
		int[] line = graph[index];
		for (int i = 0; i < line.length; i++) {
			if (line[i] != 0 && line[i] != MAX) {
				nei = i;
				break;
			}
		}
		return nei;
	}

	private int getNextNeighbor(int vertex, int fromVertex) {
		int nei = -1;
		int[] line = graph[vertex];
		for (int i = fromVertex + 1; i < line.length; i++) {
			if (line[i] != 0 && line[i] != MAX) {
				nei = i;
				break;
			}
		}
		return nei;
	}

	/**
	 * 深度优先遍历
	 * @param index
	 */
	private void depthFirstSearch(int index) {
		isVisit[index] = true;
		int nei = getNeighbor(index);
		while (nei != -1) {
			if (!isVisit[nei]) {
				isVisit[nei] = true;
				System.out.println("遍历到顶点：" + nei);
				depthFirstSearch(nei);
			} else {
				nei = getNextNeighbor(index, nei);
			}
		}
	}

	/**
	 * 广度优先遍历
	 * @param index
	 */
	private void broadFirstSearch(int index) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int vertex,nei;
		queue.add(index);
		isVisit[index] = true;
		System.out.println("遍历到顶点：" + index);
		while (!queue.isEmpty()) {
			vertex = queue.removeFirst();
			nei = getNeighbor(vertex);
			while (nei != -1) {
				if (!isVisit[nei]) {
					isVisit[nei] = true;
					System.out.println("遍历到顶点：" + nei);
					queue.add(nei);
				}
				nei = getNextNeighbor(vertex, nei);
			}
		}
	}

	public void depthFirstSearch() {
		for (int i = 0; i < graph.length; i++) {
			if (!isVisit[i]) {
				System.out.println("遍历到顶点：" + i);
				depthFirstSearch(i);
			}
		}
	}

	public void broadFirstSearch() {
		for (int i = 0; i < graph.length; i++) {
			if (!isVisit[i]) {
				broadFirstSearch(i);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		// graph.depthFirstSearch();
		graph.broadFirstSearch();

	}

	/**
	 *          0              v0  v1  v2  v3  v4  v5  v6  v7
	 *         / \          v0 0   1   1   #   #   #   #   #
	 *        /   \         v1 1   0   #   1   1   #   #   #
	 *       1     2        v2 1   #   0   #   #   1   1   #
	 *      / \   / \       v3 #   1   #   0   #   #   #   1
	 *     3   4 5---6      v4 #   1   #   #   0   #   #   1
	 *      \ /             v5 #   #   1   #   #   0   1   #   
	 *       7              v6 #   #   1   #   #   1   0   #
	 *                      v7 #   #   #   1   1   #   #   0
	 */
	private int[][] initGraph() {
		int[][] graph = new int[8][8];
		graph[0] = new int[] { 0, 1, 1, MAX, MAX, MAX, MAX, MAX };
		graph[1] = new int[] { 1, 0, MAX, 1, 1, MAX, MAX, MAX };
		graph[2] = new int[] { 1, MAX, 0, MAX, MAX, 1, 1, MAX };
		graph[3] = new int[] { MAX, 1, MAX, 0, MAX, MAX, MAX, 1 };
		graph[4] = new int[] { MAX, 1, MAX, MAX, 0, MAX, MAX, 1 };
		graph[5] = new int[] { MAX, MAX, 1, MAX, MAX, 0, 1, MAX };
		graph[6] = new int[] { MAX, MAX, 1, MAX, MAX, 1, 0, MAX };
		graph[7] = new int[] { MAX, MAX, MAX, 1, 1, MAX, MAX, 0 };
		return graph;
	}

}
