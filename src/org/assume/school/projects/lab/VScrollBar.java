package org.assume.school.projects.lab;

public class VScrollBar extends PNode
{

	private PNode p1;
	
	private String catted;

	public static VScrollBar INSTANCE(PNode p1)
	{
		return new VScrollBar(p1);
	}

	private VScrollBar(PNode p1)
	{
		this.p1 = p1;
		cat();
	}

	@Override
	public int getWidth()
	{
		return p1.getWidth() + 3;
	}

	@Override
	public int getHeight()
	{
		return p1.getHeight();
	}

	private void cat()
	{
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < p1.getHeight(); i++)
		{
			if (i == 0)
				b.append(" ^ " + "\n");
			else
				if (i == p1.getHeight() - 1)
					b.append(" v " + "\n");
				else
					b.append(" # " + "\n");
		}
		
		this.catted = HCat.INSTANCE(p1,
				StrPic.INSTANCE(b.toString().split("\n"))).getString();
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
