package org.assume.ProjectEuler;

public class Multiples {

	public static void main(String[] args) {
		int t = 0;
		int n = 1;
		int n1 = 2;
		int n2 = 0;
		while (n2 <= 4000000) {
			n2 = n + n1;
			if (n1 % 2 == 0)
				t += n1;
			n = n1;
			n1 = n2;
		}
		System.out.println(t);
		while (true) {

		}
	}
}
