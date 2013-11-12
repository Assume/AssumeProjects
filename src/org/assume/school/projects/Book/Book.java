package org.assume.school.projects.Book;

import java.util.ArrayList;
import java.util.List;

public class Book
{

    private static List<Chapter> list = new ArrayList<Chapter>();

    public static void addChapter(Chapter t)
    {
	list.add(t);
    }

    public static void printChapter(int chapter)
    {
	Book.printChapter(list.get(chapter), chapter);
    }

    public static void printAll()
    {
	int i = 1;
	for (Chapter c : list.toArray(new Chapter[list.size()]))
	{

	    System.out.println("CHAPTER " + i);
	    System.out.println();
	    c.print();
	    System.out.println();
	    i++;

	}
    }

    public static void printChapter(Chapter c, int chapter)
    {
	System.out.println("CHAPTER " + chapter);
	System.out.println();
	c.print();
    }

}
