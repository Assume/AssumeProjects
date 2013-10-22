package org.assume.school.projects;

import java.io.BufferedReader;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

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
	sortAndPrint(getInput(ch.getSelectedFile()));
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
		if(s.length() == 0)
		    continue;
		if(s.matches("[0-9]+"))
		    continue;
		list.add(new Word(s));
	    }

	}
	in.close();
	return list.toArray(new Word[list.size()]);
    }

    public static void sortAndPrint(Word[] words)
    {
	WordCount.print(WordCount.sort(WordCount.count(words)));
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
		    if(words[i].getLength() == 0)
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

    public static Map<Integer, List<Word>> sort(Map<Integer, List<Word>> map)
    {
	Word toreplace;
	Integer[] ints = map.keySet().toArray(new Integer[map.size()]);
	for (int i = 0; i < ints.length; i++)
	{
	    List<Word> list = map.get(ints[i]);
	    Word[] words = list.toArray(new Word[list.size()]);
	    for (int j = 0; j < words.length - 1; j++)
		if (words[j].getLength() < words[j + 1].getLength())
		{
		    toreplace = words[j];
		    words[j] = words[j + 1];
		    words[j + 1] = toreplace;
		    j = -1;
		}
	}
	return map;
    }

}
