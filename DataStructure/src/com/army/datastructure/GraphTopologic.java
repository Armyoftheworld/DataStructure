package com.army.datastructure;

import java.util.Stack;

public class GraphTopologic {

	// 边表顶点
	class EdgeNode {
		int adjVert;
		String data;
		EdgeNode next;

		public EdgeNode(int adjVert) {
			super();
			this.adjVert = adjVert;
		}

		public int getAdjVert() {
			return adjVert;
		}

		public void setAdjVert(int adjVert) {
			this.adjVert = adjVert;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public EdgeNode getNext() {
			return next;
		}

		public void setNext(EdgeNode next) {
			this.next = next;
		}

	}

	// 邻接顶点
	class VertexNode {
		int in;
		String data;
		EdgeNode firstEdge;

		public VertexNode(int in, String data) {
			super();
			this.in = in;
			this.data = data;
		}

		public int getIn() {
			return in;
		}

		public void setIn(int in) {
			this.in = in;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public EdgeNode getFirstEdge() {
			return firstEdge;
		}

		public void setFirstEdge(EdgeNode firstEdge) {
			this.firstEdge = firstEdge;
		}
	}

	private VertexNode[] vertexNodes;

	public GraphTopologic() {
		vertexNodes = new VertexNode[14];
		VertexNode node0 = new VertexNode(0, "v0");
		VertexNode node1 = new VertexNode(0, "v1");
		VertexNode node2 = new VertexNode(2, "v2");
		VertexNode node3 = new VertexNode(0, "v3");
		VertexNode node4 = new VertexNode(2, "v4");
		VertexNode node5 = new VertexNode(3, "v5");
		VertexNode node6 = new VertexNode(1, "v6");
		VertexNode node7 = new VertexNode(2, "v7");
		VertexNode node8 = new VertexNode(2, "v8");
		VertexNode node9 = new VertexNode(1, "v9");
		VertexNode node10 = new VertexNode(1, "v10");
		VertexNode node11 = new VertexNode(2, "v11");
		VertexNode node12 = new VertexNode(1, "v12");
		VertexNode node13 = new VertexNode(2, "v13");
		vertexNodes[0] = node0;
		vertexNodes[1] = node1;
		vertexNodes[2] = node2;
		vertexNodes[3] = node3;
		vertexNodes[4] = node4;
		vertexNodes[5] = node5;
		vertexNodes[6] = node6;
		vertexNodes[7] = node7;
		vertexNodes[8] = node8;
		vertexNodes[9] = node9;
		vertexNodes[10] = node10;
		vertexNodes[11] = node11;
		vertexNodes[12] = node12;
		vertexNodes[13] = node13;

		node0.firstEdge = new EdgeNode(11);
		node0.firstEdge.next = new EdgeNode(5);
		node0.firstEdge.next.next = new EdgeNode(4);

		node1.firstEdge = new EdgeNode(8);
		node1.firstEdge.next = new EdgeNode(4);
		node1.firstEdge.next.next = new EdgeNode(2);

		node2.firstEdge = new EdgeNode(9);
		node2.firstEdge.next = new EdgeNode(6);
		node2.firstEdge.next.next = new EdgeNode(5);

		node3.firstEdge = new EdgeNode(13);
		node3.firstEdge.next = new EdgeNode(2);

		node4.firstEdge = new EdgeNode(7);

		node5.firstEdge = new EdgeNode(12);
		node5.firstEdge.next = new EdgeNode(8);

		node6.firstEdge = new EdgeNode(5);

		node8.firstEdge = new EdgeNode(7);

		node9.firstEdge = new EdgeNode(11);
		node9.firstEdge.next = new EdgeNode(10);

		node10.firstEdge = new EdgeNode(13);

		node12.firstEdge = new EdgeNode(9);
	}

	public void topoLogic() {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < vertexNodes.length; i++) {
			if (vertexNodes[i].in == 0) {
				stack.push(i);
			}
		}
		int count = 0, k = 0;
		while (!stack.isEmpty()) {
			int index = stack.pop();
			System.out.println("顶点" + vertexNodes[index].data);
			count++;
			for (EdgeNode node = vertexNodes[index].firstEdge; node != null; node = node.next) {
				k = node.adjVert;
				if (--vertexNodes[k].in == 0) {
					stack.push(k);
				}
			}
		}
		if (count == vertexNodes.length) {
			System.out.println("count=" + count);
		} else {
			System.out.println("拓扑排序失败");
		}
	}

	public static void main(String[] args) {
		GraphTopologic graphTopologic = new GraphTopologic();
		graphTopologic.topoLogic();
	}

}
