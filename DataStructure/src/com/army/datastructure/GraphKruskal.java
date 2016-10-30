package com.army.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

/**
 * 最小生成树：克鲁斯卡尔算法
 * @author dai
 *
 */
public class GraphKruskal {
	public int MAX = 65535;
	private int[][] graph;
	private int parent[];
	private ArrayList<Graph> graphs = new ArrayList<GraphKruskal.Graph>();

	class Graph {
		int start, end, weight;
	}

	public GraphKruskal() {
		graph = initGraph();
		parent = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			for (int j = i + 1; j < graph[i].length; j++) {
				int weight = graph[i][j];
				if (weight < MAX && weight > 0) {
					Graph graph = new Graph();
					graph.start = i;
					graph.end = j;
					graph.weight = weight;
					graphs.add(graph);
				}
			}
		}
		Collections.sort(graphs, new Comparator<Graph>() {

			@Override
			public int compare(Graph arg0, Graph arg1) {
				return arg0.weight - arg1.weight;
			}
		});
	}

	private int find(int[] parent, int v) {
		while (parent[v] > 0) {
			v = parent[v];
		}
		return v;
	}

	public void kruskal() {
		int[] parent = new int[graph.length];//数组的下标为起点，值为终点
		int sum = 0;
		int m, n;
		for (Graph graph : graphs) {
			m = find(parent, graph.start);
			n = find(parent, graph.end);
			if (m != n) {
				System.out.println("顶点" + graph.start + "到顶点" + graph.end
						+ "的权重:" + graph.weight);
				parent[m] = n;
				sum += graph.weight;
			}
		}
		System.out.println("最小权值为"+sum);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphKruskal kruskal = new GraphKruskal();
		kruskal.kruskal();
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
