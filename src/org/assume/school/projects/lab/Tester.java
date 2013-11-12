package org.assume.school.projects.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester
{

	public static void main(String[] args)
	{

		List<String> l = Arrays.asList(new String[] { "hey", "bob", "adasd",
				"adasdasd", "asasdasdasd", "asdasd" });
		List<String> l1 = Arrays.asList(new String[] { "hey123", "bo123b", "adaasdsd",
				"adas123dasd", "asasda123sdasd", "asdadasdsd" });
		List<String> l3 = Arrays.asList(new String[] { "hey123", "bo123b", "adaasdsd",
				"adas123dasd", "asasda123sdasd", "asdadasdsd", "123123123123123123123123123", "1239012031923" });
		list.add(new VerticalPicture(l));
		list.add(new VerticalPicture(l1));
		list.add(new VerticalPicture(l3));
		print();

	}

	private static List<VerticalPicture> list = new ArrayList<VerticalPicture>();

	public static void print()
	{
		int width = 0;
		for (VerticalPicture x : list)
		{
			int l = x.getLongestWordLength();
			if (l > width)
				width = l;
		}
		for (int i = 0; i < width + 6; i++)
		{
			if (i == 0 || i == width + 5)
				System.out.print("+");
			else
				System.out.print("*");
		}
		System.out.println();

		for (VerticalPicture y : list)
		{
			String[] words = y.getWords();
			System.out.print("* ");
			for (int b = 0; b < width + 3; b++)
			{
				if (b == 0 || b == (width + 1))
					System.out.print("+");
				else
					if (b == width + 2)
						System.out.print(" *");
					else
						System.out.print("*");
			}
			System.out.println();
			for (int t = 0; t < words.length; t++)
			{
				System.out.print("*");
				System.out.print(" ");
				System.out.print("*");
				System.out.print(words[t]);
				for (int f = 0; f < width - words[t].length(); f++)
					System.out.print(" ");
				System.out.print("* *");
				System.out.println();
			}
			for (int b = 0; b < width + 3; b++)
			{
				if (b == 0)
				{
					System.out.print("*");
					System.out.print(" +");
				}
				else
					if (b == (width + 1))
					{
						System.out.print("+ *");
						break;
					}
					else
						System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < width + 6; i++)
		{
			if (i == 0 || i == width + 5)
				System.out.print("+");
			else
				System.out.print("*");
		}
	}

}
