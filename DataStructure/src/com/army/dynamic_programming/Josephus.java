package com.army.dynamic_programming;

/**
 * 约瑟夫杀人（约瑟夫环）
 * 
 * @author dai
 *
 */
public class Josephus {

	class Node {
		int value = 0;
		Node next;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	private int MAX = 20;
	private int m = 5;

	public void killPerson() {
		Node header = new Node(1);
		Node flag = header;
		int i = 2;
		while (i <= MAX) {
			flag.next = new Node(i);
			flag = flag.next;
			i++;
		}
		flag.next = header;

		flag = header;
		while (flag != flag.next) {
			for (i = 1; i < m - 1; i++) {
				flag = flag.next;
			}
			System.out.println("kill person:" + flag.next.value);
			flag.next = flag.next.next;
			flag = flag.next;
		}
		System.out.println("最后留下了：" + flag.value);
	}

	public static void main(String[] args) {
		Josephus josephus = new Josephus();
		josephus.killPerson();
	}

}
