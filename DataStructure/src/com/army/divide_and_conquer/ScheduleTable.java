package com.army.divide_and_conquer;

/**
 * 分治法:<br>
 * 循环赛日常表，下面是结果（长度是2的N次幂）<br>
 * 1 2 3 4 5 6 7 8 <br>
 * 2 1 4 3 6 5 8 7 <br>
 * 3 4 1 2 7 8 5 6 <br>
 * 4 3 2 1 8 7 6 5 <br>
 * 5 6 7 8 1 2 3 4 <br>
 * 6 5 8 7 2 1 4 3 <br>
 * 7 8 5 6 3 4 1 2 <br>
 * 8 7 6 5 4 3 2 1 <br>
 * 
 * @author Army
 *
 */
public class ScheduleTable {

	public void scheduleTable(int[][] table, int size) {
		if (size == 1) {
			table[0][0] = 1;
		} else {
			// 填充左上角区域
			int subSize = size / 2;
			scheduleTable(table, subSize);

			// 填充右上角区域
			for (int i = 0; i < subSize; i++) {
				for (int j = 0; j < subSize; j++) {
					table[i][j + subSize] = table[i][j] + subSize;
				}
			}

			// 填充左下角区域
			for (int i = 0; i < subSize; i++) {
				for (int j = 0; j < subSize; j++) {
					table[i + subSize][j] = table[i][j + subSize];
				}
			}

			// 填充右下角区域
			for (int i = 0; i < subSize; i++) {
				for (int j = 0; j < subSize; j++) {
					table[i + subSize][j + subSize] = table[i][j];
				}
			}

		}
	}

	public static void main(String[] args) {
		ScheduleTable scheduleTable = new ScheduleTable();
		int[][] table = new int[8][8];
		scheduleTable.scheduleTable(table, 8);
		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table.length; col++) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
		}

	}

}
