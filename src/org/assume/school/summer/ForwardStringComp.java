package org.assume.school.summer;

import java.util.Comparator;

public class ForwardStringComp implements Comparator<String> 
{
   
	@Override
	public int compare(String arg0, String arg1) {
		return arg0.toLowerCase().compareTo(arg1.toLowerCase());
	}
}