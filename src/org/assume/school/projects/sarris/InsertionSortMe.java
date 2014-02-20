package org.assume.school.projects.sarris;

public class InsertionSortMe {

<<<<<<< HEAD
	private int arr[];

	public InsertionSortMe(int... arr) {
=======
	private Comparable[] arr;

	public InsertionSortMe(Comparable... arr) {
>>>>>>> 42749f6e13f436ef1c9b34ede1bdf5e04feddef5
		this.arr = arr;
	}

	public int sortMe() {
		if (this.arr == null)
			return -1;
		int swaps = -1;
<<<<<<< HEAD
		int let;
=======
		Comparable<Object> let;
>>>>>>> 42749f6e13f436ef1c9b34ede1bdf5e04feddef5
		int i;
		int j;
		for (i = 1; i < this.arr.length; i++) {
			let = this.arr[i];
<<<<<<< HEAD
			for (j = i - 1; (j >= 0) && (this.arr[j] > let); j--) {
=======
			for (j = i - 1; (j >= 0) && (this.arr[j].compareTo(let) > 0); j--) {
>>>>>>> 42749f6e13f436ef1c9b34ede1bdf5e04feddef5
				this.arr[j + 1] = this.arr[j];
				swaps++;
			}
			this.arr[j + 1] = let;
			swaps++;
		}
		return swaps >= 0 ? swaps + 1 : swaps;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 42749f6e13f436ef1c9b34ede1bdf5e04feddef5
