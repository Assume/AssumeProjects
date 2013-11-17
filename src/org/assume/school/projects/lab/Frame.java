package org.assume.school.projects.lab;


public class Frame extends FNode
{

	public static void main(String[] args)
	{
		String[] words = { "Spring", "In the", "Big old summer" };
		System.out.println(new Frame(new HCat(new String[] {},new Frame(new Frame(new StrPic(words))), new StrPic(new String[] {"Hey big", "bob boy big"}))).getString());
		System.out.println();
	}
 
	private String framed;
	
	private int height;
	private int width;

	public Frame(PNode p1)
	{
		super(p1.getWords(), p1);
		framed = frame();
		super.setWords(framed.split("\n"));
	}

	@Override
	public int getWidth()
	{
		return this.width;
	}

	@Override
	public int getHeight()
	{
		return this.height;
	}

	private StringBuilder topBar(int wOrig)
	{
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < wOrig + 2; i++)
		{
			b.append(i == 0 | i == wOrig + 1 ? "+" : "-");
		}
		b.append("\n");
		return b;
	}

	private StringBuilder content(String[] words, StringBuilder b)
	{
		for (String i : words)
		{
			b.append("|" + i);
			for (int j = 0; j < super.getP1().getWidth() - i.length(); j++)
			{
				b.append(" ");
			}
			b.append("|");
			b.append("\n");
		}
		return b;
	}

	private StringBuilder bottomBar(int wOrig, StringBuilder b)
	{
		for (int i = 0; i < wOrig + 2; i++)
		{
			b.append(i == 0 | i == wOrig + 1 ? "+" : "-");
		}
		return b;
	}

	private String frame()
	{
		String s = super.getP1().getString();
		int wOrig = super.getP1().getWidth();
		this.width = wOrig + 2;
		this.height = super.getP1().getHeight() + 2;
		String[] words = s.split("\n");
		StringBuilder b = bottomBar(wOrig, (content(words, topBar(wOrig))));
		return b.toString();
	}

	@Override
	public String getString()
	{
		return this.framed;
	}

}
