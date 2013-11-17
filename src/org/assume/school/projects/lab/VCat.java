package org.assume.school.projects.lab;

public class VCat extends PNode
{

	private String catted;
	private PNode p1;
	private PNode p2;

	public VCat(PNode p1, PNode p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		catted = cat();
		super.setWords(catted.split("\n"));
	}

	private String cat()
	{
		StringBuilder b = new StringBuilder(p1.getString());
		String[] p2Str = p2.getWords();
		for (int i = 0; i < p2Str.length; i++)
		{
			b.append(p2Str[i] + "\n");
		}
		return b.toString();

	}

	@Override
	public int getWidth()
	{
		return p1.getWidth() >= p2.getWidth() ? p1.getWidth() : p2
				.getWidth();
	}

	@Override
	public int getHeight()
	{
		return p1.getHeight() + p2.getHeight();
	}

	@Override
	public String getString()
	{
		return this.catted;
	}


}
