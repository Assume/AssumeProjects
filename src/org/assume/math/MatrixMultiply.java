package org.assume.math;

import java.awt.Point;

public class MatrixMultiply extends MatrixExecutor {

	public MatrixMultiply(Matrix x, Matrix y) {
		super(x, y);
	}

	@Override
	public MatrixAnswer execute() {
		if (x.size().y != y.size().x)
			return null;
		Point size_first = x.size();
		Point size_second = y.size();
		Matrix an = new Matrix(size_first.x, size_second.y, super.x.name()
				+ " times " + super.y.name());
		MatrixWork work = new MatrixWork(size_first.x, size_second.y,
				super.x.name() + " times " + super.y.name());
		for (int i = 0; i < size_first.x; i++) {
			for (int k = 0; k < size_second.y; k++) {
				int sum = 0;
				String str = "";
				for (int j = 0; j < size_second.x; j++) {
					sum = sum + x.get(i, j) * this.y.get(j, k);
					str += j == 0 ? "(" + x.get(i, j) + " * "
							+ this.y.get(j, k) + ")" : " + (" + x.get(i, j)
							+ " * " + this.y.get(j, k) + ")";
				}
				an.set(i, k, sum);
				work.set(i, k, str);
				sum = 0;
				str = "";
			}
		}
		return new MatrixAnswer(an, work, x, y);
	}
}
