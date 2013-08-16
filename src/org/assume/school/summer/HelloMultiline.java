package org.assume.school.summer;

public class HelloMultiline extends HelloSimple
{
	public HelloMultiline()
	{
		super("Sorry, no message".replace(" ", "\n"));
	}

	public HelloMultiline(String txt)
	{
		super(txt.replace(" ", "\n"));
	}
	
}
