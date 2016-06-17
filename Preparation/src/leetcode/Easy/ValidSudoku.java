package leetcode.Easy;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSudokuValid(char[][] matrix) {
		for (int i = 0; i < 9; i++) {
			if (!isValid(matrix, i, i, 0, 8)) {
				return false;
			}

			if (!isValid(matrix, 0, 8, i, i)) {
				return false;
			}

			if (!isValid(matrix, (i / 3) * 3, (i / 3) * 3 + 2, (i % 3) * 3,
					(i % 3) * 3 + 2)) {
				return false;
			}
		}
		return true;

	}

	public static boolean isValid(char[][] matrix, int i, int j, int x, int y) {
		// i = start point for X axis
		// j = end index for X axis(inclusive_
		// x = start index for Y axis
		// y = end index for Y axis(inclusive)
		boolean[] trackNumbers = new boolean[10];
		for (int p = i; p <= j; p++) {
			for (int q = x; q <= y; q++) {
				if (matrix[p][q] != '.') {
					if (trackNumbers[Character.getNumericValue(matrix[p][q])])
						return false;
					else {
						trackNumbers[Character.getNumericValue(matrix[p][q])] = true;
					}
				}
			}
		}
		return true;
	}
}
