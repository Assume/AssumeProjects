package org.assume.school.projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class WordCount
{

    public static void main(String[] args) throws IOException
    {

	JFileChooser ch = new JFileChooser();
	ch.setFileSelectionMode(JFileChooser.FILES_ONLY);
	ch.setFileFilter(new FileFilter()
	{

	    @Override
	    public boolean accept(File pathname)
	    {
		return pathname.toString().endsWith(".txt")
			|| pathname.isDirectory();
	    }

	    @Override
	    public String getDescription()
	    {
		return null;
	    }
	});
	ch.showOpenDialog(null);
	sortAndPrint(getInput(ch.getSelectedFile()), true);
    }

    public static void sortAndPrint(Word[] words, boolean horizontal)
    {
	long start = System.currentTimeMillis();
	if (!horizontal)
	    WordCount.print(WordCount.shellSort(WordCount.count(words)));
	else
	    WordCount.printHorizontal(WordCount.sortAlphabetically(WordCount
		    .count(words)));
	System.out.println((System.currentTimeMillis() - start));
    }

    public static Word[] getInput(File f) throws IOException
    {
	List<Word> list = new ArrayList<Word>();
	BufferedReader in = new BufferedReader(new FileReader(f));
	String str;
	while ((str = in.readLine()) != null)
	{
	    for (String s : str.split(" "))
	    {
		s = s.replaceAll("[^a-zA-Z0-9&&[^-]]", "");
		if (s.length() == 0)
		    continue;
		if (s.matches("[0-9]+"))
		    continue;
		list.add(new Word(s));
	    }

	}
	in.close();
	return list.toArray(new Word[list.size()]);
    }

    public static int getMax(List<Integer> list, Integer[] ints)
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

    public static int getSmallest10s(Integer[] array)
    {
	int smallest = Integer.MAX_VALUE;
	for (int i = 0; i < array.length; i++)
	{
	    if (Integer.toString(array[i]).length() == 2)
		if (array[i] < smallest)
		{
		    smallest = array[i];
		}
	}
	if (smallest == Integer.MAX_VALUE)
	    return 0;
	return smallest;
    }

    public static int getMaximum(Integer[] array)
    {
	int largest = Integer.MIN_VALUE;
	for (int i = 0; i < array.length; i++)
	{
	    if (array[i] > largest)
	    {
		largest = array[i];
	    }
	}
	return largest;
    }

    public static void printHorizontal(Map<Integer, List<Word>> map)
    {
	Integer[] ints = WordCount.smallestToLargest(map.keySet().toArray(
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
	    else if (ints[t] == getSmallest10s(ints)
		    || ints[t] == getMaximum(ints))
		System.out.print("  | ");
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
		if (ints[i] % 5 == 0)
		{
		    paran = "(" + map.get(ints[i]).get(0).getLength() + ") ";
		}
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

    public static void print(Map<Integer, List<Word>> map)
    {
	Integer[] ints = WordCount.smallestToLargest(map.keySet().toArray(
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

    public static Integer[] smallestToLargest(Integer[] doubleArray)
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

    public static Map<Integer, List<Word>> count(Word[] words)
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

    public static Map<Integer, List<Word>> shellSort(
	    Map<Integer, List<Word>> map)
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

    public static Map<Integer, List<Word>> sortAlphabetically(
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

    public static Map<Integer, List<Word>> sort(Map<Integer, List<Word>> map)
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
