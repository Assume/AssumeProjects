package org.assume.math;

public abstract class MatrixExecutor {

	protected Matrix x;
	protected Matrix y;

	public MatrixExecutor(Matrix x, Matrix y) {
		this.x = x;
		this.y = y;
	}

	public abstract MatrixAnswer execute();

}
