package org.assume.school.summer;

import java.util.Arrays;

public class HelloSorted extends HelloSimple
{
	private boolean  reverseOrder;

	public HelloSorted() {  
		super();  
		this.reverseOrder = false;
	}
	public HelloSorted(boolean reverseOrder) 
	{
		super();
		this.reverseOrder = reverseOrder;
	}
	// String argument constructor
	public HelloSorted(String message)
	{ 
		super(message);  
		this.reverseOrder = false;
	}

	public HelloSorted(String message, boolean reverseOrder) 
	{
		super(message);
		this.reverseOrder = reverseOrder;
	}
	public boolean reverseOrder() 
	{
		return  this.reverseOrder;
	}

	@Override 
	public String getMessage() {  		
		String msg = super.getMessage();							
		String[] words = msg.split( "\\W+" );			 

		if (reverseOrder()) {
			ReverseStringComp reverse = new ReverseStringComp();
			Arrays.sort( words, reverse );					
		}
		else {
			ForwardStringComp forward = new ForwardStringComp();
			Arrays.sort( words, forward );					
		}

		StringBuilder  sb = new StringBuilder();		
		for (String aWord : words) {								
			sb.append( aWord + " " );								
		}

		return  sb.toString();  										
	}
}