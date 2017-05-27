package org.assume.math;

import java.awt.Point;

public class MatrixAdd extends MatrixExecutor {

	public MatrixAdd(Matrix x, Matrix y) {
		super(x, y);
	}

	public MatrixAnswer execute() {
		if (!x.size().equals(y.size()))
			return null;
		Point size = x.size();
		Matrix an = new Matrix(size.x, size.y, super.x.name() + " plus " + super.y.name());
		MatrixWork work = new MatrixWork(size.x, size.y, super.x.name() + " plus " + super.y.name());
		for (int i = 0; i < size.x; i++)
			for (int j = 0; j < size.y; j++) {
				an.set(i, j, this.x.get(i, j) + this.y.get(i, j));
				work.set(i, j, this.x.get(i, j) + " + " + this.y.get(i, j));
			}
		return new MatrixAnswer(an, work, x, y);
	}

}
