package org.assume.school.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word
{

    private String word;
    private int length;
    private int amount;

    public Word(String word)
    {
	this.word = word;
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

    public static Word[] generateRandom(int amount)
    {
	char[] az = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	List<Word> list = new ArrayList<Word>();
	Random rand = new Random();
	for (int i = 0; i < amount; i++)
	{
	    String temp = "";
	    for(int j = 1; j <= rand.nextInt(12) + 1; j++)
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

}
