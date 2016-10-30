package com.army.divide_and_conquer;

/**
 * 分治法之棋盘覆盖算法
 * 
 * @author Army
 *
 */
public class ChessBoardFill {

	int type = 0;

	/**
	 * 
	 * @param table
	 *            棋盘（长度是2的N次幂）
	 * @param specialRow
	 *            特殊点的行下标
	 * @param specialCol
	 *            特殊点的列下标
	 * @param leftRow
	 *            棋盘分割的每一块的左起点的行下标
	 * @param leftCol
	 *            棋盘分割的每一块的左起点的列下标
	 * @param size
	 */
	public void chessBoardFill(int[][] table, int specialRow, int specialCol, int leftRow, int leftCol, int size) {
		if (size == 1)
			return;
		type = type % 9 + 1;
		int n = type;
		int subSize = size / 2;

		// 判断是否在左上角
		if (specialRow < leftRow + subSize && specialCol < leftCol + subSize) {
			chessBoardFill(table, specialRow, specialCol, leftRow, leftCol, subSize);
		} else {
			// 不在左上角，那左上角矩阵的右下角一定是一个特殊点（在这块区域内与其他的点不一样）
			table[leftRow + subSize - 1][leftCol + subSize - 1] = n;
			chessBoardFill(table, leftRow + subSize - 1, leftCol + subSize - 1, leftRow, leftCol, subSize);
		}

		// 判断是否在右上角
		if (specialRow < leftRow + subSize && specialCol >= leftCol + subSize) {
			chessBoardFill(table, specialRow, specialCol, leftRow, leftCol + subSize, subSize);
		} else {
			// 不在右上角，那右上角矩阵的左下角一定是一个特殊点（在这块区域内与其他的点不一样）
			table[leftRow + subSize - 1][leftCol + subSize] = n;
			chessBoardFill(table, leftRow + subSize - 1, leftCol + subSize, leftRow, leftCol + subSize, subSize);
		}

		// 判断是否在左下角
		if (specialRow >= leftRow + subSize && specialCol < leftCol + subSize) {
			chessBoardFill(table, specialRow, specialCol, leftRow + subSize, leftCol, subSize);
		} else {
			// 不在左下角，那左下角矩阵的右上角一定是一个特殊点（在这块区域内与其他的点不一样）
			table[leftRow + subSize][leftCol + subSize - 1] = n;
			chessBoardFill(table, leftRow + subSize, leftCol + subSize - 1, leftRow + subSize, leftCol, subSize);
		}

		// 判断是否在右下角
		if (specialRow >= leftRow + subSize && specialCol >= leftCol + subSize) {
			chessBoardFill(table, specialRow, specialCol, leftRow + subSize, leftCol + subSize, subSize);
		} else {
			// 不在右下角，那右下角矩阵的左上角一定是一个特殊点（在这块区域内与其他的点不一样）
			table[leftRow + subSize][leftCol + subSize] = n;
			chessBoardFill(table, leftRow + subSize, leftCol + subSize, leftRow + subSize, leftCol + subSize, subSize);
		}
	}

	public static void main(String[] args) {
		ChessBoardFill boardFill = new ChessBoardFill();
		int size = 4;
		int[][] table = new int[size][size];
		boardFill.chessBoardFill(table, 2, 2, 0, 0, size);
		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table.length; col++) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
		}
	}

}
