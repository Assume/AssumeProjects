package org.assume.school.projects.lab;

public class StrPic extends PNode
{

	private String completed;

	public StrPic(String[] words)
	{
		super(words);
		this.completed = this.toSingleString();
	}

	@Override
	public int getWidth()
	{
		return this.getLongestWordLength();
	}

	@Override
	public int getHeight()
	{
		return super.getWords().length;
	}

	@Override
	public String getString()
	{
		return this.completed;
	}

	private String toSingleString()
	{
		StringBuilder b = new StringBuilder();
		for (String w : super.getWords())
		{
			b.append(w + "\n");
		}
		return b.toString();
	}

	private int getLongestWordLength()
	{
		int max = 0;
		for (String w : super.getWords())
		{
			int len = w.length();
			if (len > max)
				max = len;
		}
		return max;
	}

}
