package test;

import java.util.ArrayList;
import java.util.List;

public class AmazonTest3 {

	static int[] iMove = { 0, 0, 1, -1 };
	static int[] jMove = { 1, -1, 0, 0 };
	static boolean[][] visited;

	private static void updateServer(int i, int j, int row, int col, ArrayList<ArrayList<Integer>> grid) {

		for (int m = 0; m < iMove.length; m++) {
			if (validCell(i + iMove[m], j + jMove[m], row, col, grid)) {
				grid.get(i + iMove[m]).set(j + jMove[m], 1);
			}
		}

	}

	private static boolean validCell(int i, int j, int row, int col, ArrayList<ArrayList<Integer>> grid) {
		if (i >= 0 && j >= 0 && i < row && j < col && grid.get(i).get(j) == 0)
			return true;
		else
			return false;
	}

	private static void updateVisited(int row, int col, ArrayList<ArrayList<Integer>> grid) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid.get(i).get(j) == 1)
					visited[i][j] = true;
				else
					visited[i][j] = false;
			}
		}

	}

	private static boolean isAllUpdated(int row, int col, ArrayList<ArrayList<Integer>> grid) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid.get(i).get(j) == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static int countNumberOfDays(int row, int col, ArrayList<ArrayList<Integer>> grid) {
		int count = 0;
		visited = new boolean[row][col];
		while (!isAllUpdated(row, col, grid)) {
			count++;
			//System.out.println("Day: " + count);

			updateVisited(row, col, grid);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (grid.get(i).get(j) == 1 && visited[i][j] == true)
						updateServer(i, j, row, col, grid);
				}
			}

		}
		return count;

	}

	// driver method
	public static void main(String[] args) {

		int row = 4;
		int col = 5;

		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < col; i++) {
			grid.add(new ArrayList<Integer>());
		}

		grid.get(0).add(0);
		grid.get(0).add(1);
		grid.get(0).add(1);
		grid.get(0).add(0);
		grid.get(0).add(1);
		grid.get(1).add(0);
		grid.get(1).add(1);
		grid.get(1).add(0);
		grid.get(1).add(1);
		grid.get(1).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grid.get(2).add(1);
		grid.get(3).add(0);
		grid.get(3).add(1);
		grid.get(3).add(0);
		grid.get(3).add(0);
		grid.get(3).add(0);

		System.out.println(countNumberOfDays(row, col, grid));

	}

}
