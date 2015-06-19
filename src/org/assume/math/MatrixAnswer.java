package org.assume.math;

public class MatrixAnswer {

	private Matrix original_one;
	private Matrix original_two;
	private Matrix fin;
	private MatrixWork work;

	public MatrixAnswer(Matrix fin, MatrixWork work, Matrix original_one,
			Matrix original_two) {
		this.fin = fin;
		this.work = work;
		this.original_one = original_one;
		this.original_two = original_two;
	}

	public Matrix answer() {
		return fin;
	}

	public String print() {
		return original_one.name() + ": \n" + this.original_one.print() + "\n\n"
				+ original_two.name() + ":\n" + original_two.print()
				+ "\n\nAnswer: \n" + this.fin.print() + "\n\nWork: \n"
				+ this.work.print();
	}

	@Override
	public String toString() {
		return fin.name();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof MatrixAnswer))
			return false;
		return ((MatrixAnswer) other).toString().equals(this.toString());
	}

}
