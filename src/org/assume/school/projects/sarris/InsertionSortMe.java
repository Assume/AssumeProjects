package org.assume.school.projects.sarris;

public class InsertionSortMe {

	private Comparable[] arr;

	public InsertionSortMe(Comparable... arr) {
		this.arr = arr;
	}

	public int sortMe() {
		if (this.arr == null)
			return -1;
		int swaps = -1;
		Comparable<Object> let;
		int i;
		int j;
		for (i = 1; i < this.arr.length; i++) {
			let = this.arr[i];
			for (j = i - 1; (j >= 0) && (this.arr[j].compareTo(let) > 0); j--) {
				this.arr[j + 1] = this.arr[j];
				swaps++;
			}
			this.arr[j + 1] = let;
			swaps++;
		}
		return swaps >= 0 ? swaps + 1 : swaps;
	}

}