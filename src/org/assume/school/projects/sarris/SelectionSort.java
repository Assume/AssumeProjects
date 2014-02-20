package org.assume.school.projects.sarris;


public class SelectionSort {
	private int[] arr;

	public SelectionSort(int... arr) {
		this.arr = arr;
	}
	
	/* I didn't store the swaps a instance variable as if they called #sort more than once it would return an incorrect value */

	public int sort() {
		if (this.arr == null)
			throw new IllegalArgumentException();
		int swaps = -1;
		int low = 0;
		for (int i = 0; i < this.arr.length - 1; i++) {
			low = i;
			for (int j = i + 1; j < this.arr.length; j++) {
				if (this.arr[j] < this.arr[low]) {
					low = j;
				}
			}
			if (low != i) {
				int temp = this.arr[i];
				this.arr[i] = this.arr[low];
				this.arr[low] = temp;
				swaps++;
			}
		}
		return swaps >= 0 ? swaps + 1 : swaps;
	}

}
