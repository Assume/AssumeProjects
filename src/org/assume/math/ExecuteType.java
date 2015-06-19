package org.assume.math;

public enum ExecuteType {

	ADD {
		@Override
		public MatrixAnswer execute(Matrix one, Matrix two) {
			return new MatrixAdd(one, two).execute();
		}
	}

	,
	SUBTRACT {
		@Override
		public MatrixAnswer execute(Matrix one, Matrix two) {
			return new MatrixSubtract(one, two).execute();
		}
	},
	MULTIPLY {
		@Override
		public MatrixAnswer execute(Matrix one, Matrix two) {
			return new MatrixMultiply(one, two).execute();
		}
	};

	public abstract MatrixAnswer execute(Matrix one, Matrix two);

}
