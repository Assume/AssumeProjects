package org.assume.school.projects.sarris;

public class QuickSortMe {

	public static void main(String[] args) {
		new QuickSortMe(5, 1, 9, 3, 15).sortMe();

	}

	private int[] arr;

	public QuickSortMe(int... arr) {
		this.arr = arr;
	}

	public void sortMe() {
		sort(0, arr.length - 1);
		for (int x : arr)
			System.out.println(x);
	}

	public void sort(int l, int r) {
		if (r - l <= 0)
			return;
		else {
			int p = arr[r];
			int pLoc = part(l, r, p);
			sort(l, pLoc - 1);
			sort(pLoc + 1, r);
		}

	}

	public int part(int left, int rp, int pivot) {
		int lp = left - 1;

		while (true) {
			while (arr[++lp] < pivot)
				;
			while (rp > 0 && arr[--rp] > pivot)
				;
			if (lp >= rp)
				break;
			else
				swap(lp, rp);
		}
		swap(lp, rp);

		return lp;
	}

	public void swap(int one, int two) {
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;

	}

}
