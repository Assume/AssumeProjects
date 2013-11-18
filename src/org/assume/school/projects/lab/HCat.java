package org.assume.school.projects.lab;

public class HCat extends PNode
{

	private String catted;
	private PNode p1;
	private PNode p2;

	public static HCat INSTANCE(PNode p1, PNode p2)
	{
		return new HCat(p1, p2);
	}
	
	private HCat(PNode p1, PNode p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		catted = cat();
		super.setWords(catted.split("\n"));
	}

	private String cat()
	{

		StringBuilder b = new StringBuilder();
		String[] p1Str = p1.getWords();
		String[] p2Str = p2.getWords();
		for (int i = 0; i < p1Str.length && i < p2Str.length; i++)
		{
			b.append(p1Str[i].concat(p2Str[i]));
			b.append("\n");
		}
		if (p1Str.length > p2Str.length)
		{
			int max = p1Str.length - p2Str.length;
			for (int i = (p1Str.length - max); i < p1Str.length; i++)
				b.append(p1Str[i] + "\n");
		}
		else
			if (p2Str.length > p1Str.length)
			{
				int lon = this.getLongestWordLength(p1.getWords());
				int max = p2Str.length - p1Str.length;
				for (int i = (p2Str.length - max); i < p2Str.length; i++)
				{
					for (int x = 0; x < lon; x++)
						b.append(" ");
					b.append(p2Str[i] + "\n");
				}
			}

		return b.toString();

	}

	private int getLongestWordLength(String[] words)
	{
		int max = 0;
		for (String w : words)
		{
			int len = w.length();
			if (len > max)
				max = len;
		}
		return max;
	}

	@Override
	public int getWidth()
	{
		return p1.getWidth() + p2.getWidth();
	}

	@Override
	public int getHeight()
	{
		return p1.getHeight() >= p2.getHeight() ? p1.getHeight() : p2
				.getHeight();
	}

	@Override
	public String getString()
	{
		return this.catted;
	}


	@Override
	public String toString()
	{
		return catted;
	}
	
}
