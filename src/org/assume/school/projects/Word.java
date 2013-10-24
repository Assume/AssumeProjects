package org.assume.school.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word implements Comparable<Word>
{

   
    
    private String word;
    private int length;
    private int amount;

    public Word(String word)
    {
	this.word = word.toLowerCase();
	this.length = word.length();
	this.amount = 0;
    }

    public int getLength()
    {
	return length;
    }

    public void incrementAmount()
    {
	this.amount++;
    }

    public int getAmount()
    {
	return this.amount;
    }

    public void setLength(int length)
    {
	this.length = length;
    }

    public String getWord()
    {
	return word;
    }

    public void setWord(String word)
    {
	this.word = word;
    }

    public static String generateRandomString(int length)
    {
	char[] az = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	Random rand = new Random();

	String temp = "";
	for (int j = 1; j <= rand.nextInt(length) + 1; j++)
	{
	    temp = temp.concat(Character.toString(az[rand.nextInt(26)]));
	}

	return temp;
    }

    public static Word[] generateRandom(int amount)
    {
	char[] az = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	List<Word> list = new ArrayList<Word>();
	Random rand = new Random();
	for (int i = 0; i < amount; i++)
	{
	    String temp = "";
	    for (int j = 1; j <= rand.nextInt(12) + 1; j++)
	    {
		temp = temp.concat(Character.toString(az[rand.nextInt(26)]));
	    }
	    list.add(new Word(temp));
	}
	return list.toArray(new Word[list.size()]);
    }

    @Override
    public boolean equals(Object ob)
    {
	if (!(ob instanceof Word))
	    return false;

	if (this.getWord().equals(((Word) ob).getWord()))
	    return true;
	return false;

    }

    @Override
    public int compareTo(Word arg0)
    {
	if(this.getWord() != null && arg0.getWord() != null)
	{
	  return this.getWord().compareToIgnoreCase(arg0.getWord());
	}
	return 0;
    }

}
