package org.assume.school.projects.lab;

public class HCat extends PNode
{

	private String catted;
	
	public HCat(String[] words)
	{
		super(words);
		catted = cat();
	}

	private String cat()
	{
		return catted;
		
	}
	
	@Override
	public int getWidth()
	{
		return 0;
	}

	@Override
	public int getHeight()
	{
		
		return 0;
	}

	@Override
	public String getString()
	{
		return null;
	}

}
