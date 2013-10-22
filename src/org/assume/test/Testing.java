package org.assume.test;

public class Testing
{
	
	public static void main(String[] args) 
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println(i);
			if(i == 3)
			{
				i = i - 1;
				continue;
			}
		}

	}

}
