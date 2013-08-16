package org.assume.school.summer;

import java.util.Comparator;


public class ReverseStringComp implements Comparator<String> 
{
	public int compare(String stringOne, String stringTwo) 
	{

		return  stringTwo.compareTo(stringOne);			
	}
}