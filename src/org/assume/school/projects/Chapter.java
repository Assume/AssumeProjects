package org.assume.school.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Chapter
{

    public static final int ALPHABETICAL_SORT = 1;
    public static final int OCCURENCE_SORT_BUBBLE = 2;
    public static final int OCCURENCE_SORT_SHELL = 3;
    public static final int HORIZONTAL_PRINT = 4;
    public static final int VERTICAL_PRINT = 5;

    private Word[] words;
    private int sortType;
    private int printType;
    private Map<Integer, List<Word>> map;

    public Chapter(final Word[] words, final int sortType, final int printType)
    {
	this.words = words;
	this.sortType = sortType;
	this.printType = printType;
	this.map = sort();
	Book.addChapter(this);
    }

    public Map<Integer, List<Word>> sort()
    {
	Map<Integer, List<Word>> map = this.count(this.words);
	switch (this.sortType)
	{
	case Chapter.OCCURENCE_SORT_BUBBLE:
	    map = this.sortByOccurence(map);
	    break;
	case Chapter.ALPHABETICAL_SORT:
	    map = this.sortAlphabetically(map);
	    break;
	case Chapter.OCCURENCE_SORT_SHELL:
	    map = this.shellSort(map);
	    break;
	}

	return map;
    }

    public void print()
    {
	if (this.printType == Chapter.VERTICAL_PRINT)
	    this.printVertical(map);
	else if (this.printType == Chapter.HORIZONTAL_PRINT)
	    this.printHorizontal(map);
    }

    private int getMax(List<Integer> list, Integer[] ints)
    {
	int largest = Integer.MIN_VALUE;
	for (int i = 0; i < ints.length; i++)
	{
	    if (ints[i] > largest)
	    {
		if (!list.contains(new Integer(i)))
		    largest = ints[i];
	    }
	}
	return largest;
    }

    private void printHorizontal(Map<Integer, List<Word>> map)
    {
	Integer[] ints = this.smallestToLargest(map.keySet().toArray(
		new Integer[map.size()]));
	List<Integer> skip = new ArrayList<Integer>();

	for (int t = 0; t < ints.length; t++)
	{

	    int y = Integer.toString(ints[t]).length() == 1 ? 1 : 2;
	    int r = y == 1 ? 1 : 0;
	    if (ints[t] == 1)
	    {
		System.out.print("| Length " + ints[t] + " | ");
		continue;
	    } else
	    {

		System.out.print("|");

		for (int j = 0; j < (ints[t] / 2) + r; j++)
		{
		    System.out.print(" ");
		}
		System.out.print("Length " + ints[t] + " ");
	    }
	    for (int x = 0; x < ((ints[t] / 2) + ints[t] % 2) - y; x++)
	    {
		System.out.print(" ");
	    }
	    if (y == 1)
		System.out.print("| ");
	    else
		System.out.print(" | ");

	}
	System.out.println();
	int i = 0;
	for (;;)
	{
	    if (i == ints.length)
	    {
		i = 0;
		System.out.println();
		continue;
	    }

	    if (skip.size() == ints.length)
	    {
		return;
	    }

	    if (i == getMax(skip, ints) + 1 || i == ints.length)
	    {
		i = 0;
		System.out.println();
	    }
	    if (skip.contains(i))
	    {
		for (int u = 0; u < (i + 13); u++)
		{
		    System.out.print(" ");
		}
		i = i == getMax(skip, ints) + 1 ? 0 : i + 1;
		continue;
	    }
	    if (i >= ints.length)
		i = 0;
	    if (map.get(ints[i]).size() > 0)
	    {

		String paran = "    ";
		String fi = "";
		if (map.get(ints[i]).get(0).getAmount() < 10)
		    fi = "   | ";
		else if (map.get(ints[i]).get(0).getAmount() >= 10
			&& map.get(ints[i]).get(0).getAmount() < 100)
		    fi = "  | ";
		System.out.print("| " + map.get(ints[i]).get(0).getWord()
			+ paran + map.get(ints[i]).get(0).getAmount() + fi);

		map.get(ints[i]).remove(0);
		if (i < getMax(skip, ints))
		    i++;
		else
		    i = 0;
		continue;
	    } else
	    {
		skip.add(i);
		continue;
	    }
	}

    }

    private void printVertical(Map<Integer, List<Word>> map)
    {
	Integer[] ints = this.smallestToLargest(map.keySet().toArray(
		new Integer[map.size()]));
	for (int i = 0; i < ints.length; i++)
	{
	    System.out.println();
	    System.out.println("Words with a length of " + ints[i]);
	    System.out.println();
	    for (Word w : map.get(ints[i]))
	    {
		System.out.println(w.getWord() + ": was used " + w.getAmount()
			+ " times");
	    }
	}
    }

    private Integer[] smallestToLargest(Integer[] doubleArray)
    {
	Integer toreplace;
	for (int i = 0; i < doubleArray.length - 1; i++)
	{
	    if (doubleArray[i] > doubleArray[i + 1])
	    {
		toreplace = doubleArray[i];
		doubleArray[i] = doubleArray[i + 1];
		doubleArray[i + 1] = toreplace;
		i = -1;
	    }
	}
	return doubleArray;
    }

    private Map<Integer, List<Word>> count(Word[] words)
    {
	Map<Integer, List<Word>> map = new HashMap<Integer, List<Word>>();

	for (int i = 0; i < words.length; i++)
	{
	    if (map.containsKey(words[i].getLength()))
	    {
		List<Word> list = map.get(words[i].getLength());
		if (list.contains(words[i]))
		{
		    list.get(list.indexOf(words[i])).incrementAmount();
		} else
		{
		    if (words[i].getLength() == 0)
			continue;
		    words[i].incrementAmount();
		    list.add(words[i]);
		}
	    } else
	    {
		List<Word> l = new ArrayList<Word>();
		words[i].incrementAmount();
		l.add(words[i]);
		map.put(words[i].getLength(), l);
	    }
	}
	return map;
    }

    private Map<Integer, List<Word>> shellSort(Map<Integer, List<Word>> map)
    {
	Integer[] ints = map.keySet().toArray(new Integer[map.size()]);

	for (int i = 0; i < ints.length; i++)
	{
	    List<Word> list = map.get(ints[i]);
	    map.remove(ints[i]);
	    Word[] words = list.toArray(new Word[list.size()]);
	    for (int j = 0; j < words.length - 1; j++)
	    {
		int length = words.length;
		int in, out;
		Word temp;
		int h = 1;
		while (h <= length / 3)
		{
		    h = h * 3 + 1;
		}
		while (h > 0)
		{
		    for (out = h; out < length; out++)
		    {
			temp = words[out];
			in = out;

			while (in > h - 1
				&& words[in - h].getAmount() <= temp
					.getAmount())
			{
			    words[in] = words[in - h];
			    in -= h;
			}
			words[in] = temp;
		    }
		    h = (h - 1) / 3;
		}
	    }
	    map.put(ints[i], new LinkedList<Word>(Arrays.asList(words)));

	}
	return map;
    }

    private Map<Integer, List<Word>> sortAlphabetically(
	    Map<Integer, List<Word>> map)
    {
	Integer[] ints = map.keySet().toArray(new Integer[map.size()]);
	for (int i = 0; i < ints.length; i++)
	{
	    List<Word> list = map.get(ints[i]);
	    map.remove(ints[i]);
	    Collections.sort(list);
	    map.put(ints[i], list);
	}

	return map;

    }

    private Map<Integer, List<Word>> sortByOccurence(
	    Map<Integer, List<Word>> map)
    {
	Word toreplace;
	Integer[] ints = map.keySet().toArray(new Integer[map.size()]);
	for (int i = 0; i < ints.length; i++)
	{
	    List<Word> list = map.get(ints[i]);
	    map.remove(ints[i]);
	    Word[] words = list.toArray(new Word[list.size()]);
	    for (int j = 0; j < words.length - 1; j++)
	    {
		if (words[j].getAmount() < words[j + 1].getAmount())
		{
		    toreplace = words[j];
		    words[j] = words[j + 1];
		    words[j + 1] = toreplace;
		    j = -1;
		}
	    }
	    map.put(ints[i], new LinkedList<Word>(Arrays.asList(words)));

	}
	return map;
    }

}
