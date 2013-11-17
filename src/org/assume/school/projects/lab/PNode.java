package org.assume.school.projects.lab;

public abstract class PNode
{

	private String[] words;

	public PNode(String[] words)
	{
		this.words = words;
	}

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract String getString();

	public String[] getWords()
	{
		return words;
	}

	public void setWords(String[] words)
	{
		this.words = words;
	}

}
