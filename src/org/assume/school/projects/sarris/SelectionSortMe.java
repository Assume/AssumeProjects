package org.assume.school.projects.sarris;

public class SelectionSortMe {

	public static void main(String[] args) {
		new SelectionSortMe(1, 2, 5, 2, 12, 19, 18, 3, 5, 12, 9).sortMe();
	}

	private int[] arr;

	public SelectionSortMe(int... arr) {
		this.arr = arr;
	}

	/*
	 * I didn't store the swaps as an instance variable as if they called #sort
	 * more than once it would return an incorrect value
	 */

	public int sortMe() {
		if (this.arr == null)
			throw new IllegalArgumentException();
		int swaps = -1;
		int low = 0;
		for (int i = 0; i < this.arr.length - 1; i++) {
			low = i;
			for (int j = i + 1; j < this.arr.length; j++)
				if (this.arr[j] < this.arr[low])
					low = j;

			if (low != i) {
				int temp = this.arr[i];
				this.arr[i] = this.arr[low];
				this.arr[low] = temp;
				swaps++;
			}
		}
		for (int x : arr)
			System.out.println(x);
		return swaps >= 0 ? swaps + 1 : swaps;
	}

}
