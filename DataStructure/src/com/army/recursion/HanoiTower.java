package com.army.recursion;

public class HanoiTower {
	private int i = 1;

	// 思想就是：假如有3个盘子，塔a,b,c，要把上面2个从a经过c移动到b，再把最后一个从a移动到c
	public void hanoiTower(int n, char from, char dependOn, char to) {
		if (n == 1) {
			move(from, to);
		} else {
			hanoiTower(n - 1, from, to, dependOn);//把上面的n-1个盘子从from经过to移动到dependOn
			move(from, to);//把最后一个直接从from移动到to
			hanoiTower(n - 1, dependOn, from, to);//把之前的n-1个盘子从dependOn经过from移动到to
		}
	}

	public void move(char from, char to) {
		System.out.println("第" + i++ + "步从" + from + "移动到" + to);
	}

	public static void main(String[] args) {
		HanoiTower hanoiTower = new HanoiTower();
		hanoiTower.hanoiTower(3, 'a', 'b', 'c');
	}
}
