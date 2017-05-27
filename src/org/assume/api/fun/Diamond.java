package org.assume.api.fun;

public class Diamond {
	public static void main(String[] args) {
		Diamond a = new Diamond();
		a.draw(25, '_', 1, '@', false);
	}

	public void draw(int max, char spacing, int x, char drawing, boolean atMax) {

		if (x < 1) {
			return;
		} else if (x > max && !atMax) {
			draw(max, spacing, x - 4, drawing, !atMax);
		} else {
			for (int r = 0; r < ((max - x) / 2); r++) {
				System.out.print(spacing);
			}
			for (int i = 0; i < x; i++) {
				System.out.print(drawing);
			}
			for (int r = 0; r < ((max - x) / 2); r++) {
				System.out.print(spacing);
			}
			System.out.println();
			if (atMax) {
				draw(max, spacing, x - 2, drawing, atMax);
			} else {
				draw(max, spacing, x + 2, drawing, atMax);
			}
		}
	}
}
