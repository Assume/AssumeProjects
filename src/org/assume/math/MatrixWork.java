package org.assume.math;

import java.awt.Point;

public class MatrixWork {

	private String[][] matrix;
	private String name;
	private int r;
	private int c;

	public MatrixWork(int row, int col, String name) {
		this.r = row;
		this.c = col;
		this.name = name;
		this.matrix = new String[row][col];
		this.init();
	}

	public String[][] getMatrix() {
		return this.matrix;
	}

	private void init() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = "UNSET";
			}
		}
	}

	public String set(int row, int col, String val) {
		return this.matrix[row][col] = val;
	}

	public String get(int row, int col) {
		return this.matrix[row][col];
	}

	public boolean setNext(int row, String num) {
		int index = findFirstUnsetIndex(row);
		if (index == -1)
			return false;
		this.matrix[row][index] = num;
		return true;
	}

	private int findFirstUnsetIndex(int row) {
		for (int i = 0; i < matrix[row].length; i++) {
			if (matrix[row][i].equals("UNSET"))
				return i;
		}
		return -1;
	}

	public Point size() {
		return new Point(this.r, this.c);
	}

	public String name() {
		return this.name;
	}

	private int getSpacesRequired(int col, String num) {
		return getLargestNumDigits(col) - num.length();
	}

	private int getLargestNumDigits(int col) {
		int largest = matrix[0][col].length();
		for (int i = 0; i < this.matrix.length; i++) {
			if (this.matrix[i][col].length() > largest)
				largest = matrix[i][col].length();
		}
		return largest;
	}

	public String print() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			if (i > 0)
				b.append("\n");
			for (int j = 0; j < matrix[i].length; j++) {
				b.append("| " + matrix[i][j] + " ");
				int spaces = getSpacesRequired(j, matrix[i][j]);
				for (int x = 0; x < spaces; x++)
					b.append(" ");
				b.append("| ");
			}
		}
		return b.toString();
	}

	@Override
	public String toString() {
		return this.name;
	}

}
