package org.assume.school.projects.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	new Chapter(getInput(ch.getSelectedFile()), Chapter.ALPHABETICAL_SORT,
		Chapter.HORIZONTAL_PRINT);
	Book.printAll();
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

}
