package org.assume.school.summer;

public abstract class Hello 
{

	public abstract void go();
	public void go(String txt) 
	{
		System.out.println(txt);
	}
	public void showName() 
	{
		System.out.println( "My name is: " + toString() + "\n==================" );
	}

}
