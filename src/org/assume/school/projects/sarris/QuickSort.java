package org.assume.school.projects.sarris;

import java.util.ArrayList;

public class QuickSort {

	public static void sortLowToHigh(int[] a) {
		quickIntSort(a, 0, a.length - 1);
	}

	public static void sortLowToHigh(ArrayList<Comparable> a) {
		quickArrayListSort(a, 0, a.size() - 1);
	}

	private static void quickArrayListSort(ArrayList<Comparable> a,
			int lestartft, int end) {
		if (end <= lestartft)
			return;
		int part = part(lestartft, end, a);
		quickArrayListSort(a, lestartft, part - 1);
		quickArrayListSort(a, part + 1, end);
	}

	private static int part(int s, int er, ArrayList<Comparable> a) {
		int i = s - 1;
		int t = er;
		while (true) {
			while (a.get(++i).compareTo(a.get(er)) < 0)
				;
			while (a.get(er).compareTo(a.get(--t)) < 0)
				if (t == s)
					break;
			if (i >= t)
				break;
			swap(i, t, a);
		}
		swap(i, er, a);
		return i;
	}

	private static void swap(int first, int second, ArrayList<Comparable> a) {
		Comparable swap = a.get(first);
		a.set(first, a.get(second));
		a.set(second, swap);
	}

	private static void quickIntSort(int[] a, int start, int end) {
		if (end <= start)
			return;
		int part = part(start, end, a);
		quickIntSort(a, start, part - 1);
		quickIntSort(a, part + 1, end);
	}

	private static int part(int l, int r, int[] a) {
		int i = l - 1;
		int t = r;
		while (true) {
			while ((a[++i] < (a[r])))
				;
			while ((a[r] < (a[--t])))
				if (t == l)
					break;
			if (i >= t)
				break;
			swap(i, t, a);
		}
		swap(i, r, a);
		return i;
	}

	private static void swap(int first, int second, int[] a) {
		int swap = a[first];
		a[first] = a[second];
		a[second] = swap;
	}

}
