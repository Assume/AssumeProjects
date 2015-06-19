package org.assume.school.projects.sarris;

import java.util.ArrayList;
import java.util.Arrays;


public class QuickSortRunner {

	public static void main(String[] args) {
				
		int a[] = {1, 2, 5, 4, 3};	
		testArray(a);
		
		int b[] = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};	
		testArray(b);
		
		int c[] = {1, 2, 3, 100, 200, 300, -1, -2, -100, 1000, 4, 123, 973, 17, -25};	
		testArray(c);
		
		int d[] = {1, 2, 5, 4, 3};
		testArrayList(d);
		
		int e[] = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
		testArrayList(e);
		
		int f[] = {1, 2, 3, 100, 200, 300, -1, -2, -100, 1000, 4, 123, 973, 17, -25};
		testArrayList(f);
		
	}
	
	public static void testArray(int[] arr)
	{
		int[] arrcopy = Arrays.copyOf(arr, arr.length);
		System.out.println("Array " + Arrays.toString(arr));
		QuickSort.sortLowToHigh(arr);
		System.out.println("   sorted low to high is " +  Arrays.toString(arr));
	}
	
	public static void testArrayList(int[] arr)
	{
		ArrayList<Comparable>al1 = new ArrayList<Comparable>();
		for (int i = 0; i < arr.length; i++)
		{
			al1.add(new Integer(arr[i]));
		}
		ArrayList<Comparable>al2 = new ArrayList<Comparable>();
		for (int i = 0; i < arr.length; i++)
		{
			al2.add(new Integer(arr[i]));
		}
		
		System.out.println("ArrayList " + Arrays.toString(arr));
		QuickSort.sortLowToHigh(al1);
		System.out.println("   sorted low to high is " + dump(al1));
	}
	
	public static String dump(ArrayList a)
	{
		String s = "";
		for (int i = 0; i < a.size(); i++)
		{
			s = s + a.get(i).toString() + " ";
		}
		return s;
	}
}
