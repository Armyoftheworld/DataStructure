package com.army.backtracking_algorithm;

/**
 * 回溯法：八皇后问题
 * 
 * @author dai
 *
 */
public class EightQueen {

	public static void main(String[] args) {
		EightQueen eightQueen = new EightQueen();
		eightQueen.queen(0);
	}

	private int num = 0;
	private int MAXQUEEN = 4;
	private int[] col = new int[MAXQUEEN];

	public void queen(int n) {
		boolean[] row = new boolean[MAXQUEEN];

		for (int m = 0; m < n; m++) {// 对于n这一列来说，把前几列所在的行去掉
			row[col[m]] = true;

			int delta = n - m;
			// 对于n这一列来说，把正斜角（/）方向上的行去掉
			if (col[m] - delta >= 0) {
				row[col[m] - delta] = true;
			}
			// 对于n这一列来说，把反斜角（\）方向上的行去掉
			if (col[m] + delta <= MAXQUEEN - 1) {
				row[col[m] + delta] = true;
			}

		}

		for (int i = 0; i < MAXQUEEN; i++) {
			if (row[i]) {
				continue;
			}
			col[n] = i;
			if (n < MAXQUEEN - 1) {
				queen(n + 1);
			} else {
				num++;
				printQueen();
			}
		}

	}

	public void printQueen() {
		System.out.println("第" + num + "种方案");
		for (int i = 0; i < MAXQUEEN; i++) {
			for (int j = 0; j < MAXQUEEN; j++) {
				if (i == col[j]) {
					System.out.print("0 ");
				} else {
					System.out.print("+ ");
				}
			}
			System.out.println();
		}
	}

}
