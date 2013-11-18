package org.assume.school.projects.lab;

public class HScrollBar extends PNode
{

	private PNode p1;

	private String catted;

	public static HScrollBar INSTANCE(PNode p1)
	{
		return new HScrollBar(p1);
	}

	private HScrollBar(PNode p1)
	{
		this.p1 = p1;
		cat();
	}

	@Override
	public int getWidth()
	{
		return p1.getWidth();
	}

	@Override
	public int getHeight()
	{
		return p1.getHeight() + 1;
	}

	private void cat()
	{
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < p1.getWidth(); i++)
		{
			if (i == 0)
				b.append("<");
			else
				if (i == p1.getWidth() - 1)
					b.append(">");
				else
					b.append("#");
		}

		this.catted = VCat.INSTANCE(p1,
				StrPic.INSTANCE(new String[] { b.toString() })).getString();
		this.setWords(this.catted.split("\n"));

	}

	@Override
	public String getString()
	{
		return this.catted;
	}

	@Override
	public String toString()
	{
		return this.catted;
	}

}
