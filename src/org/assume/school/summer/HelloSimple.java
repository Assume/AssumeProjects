package org.assume.school.summer;

public class HelloSimple extends Hello {
	private String  msg;
	public HelloSimple() 
	{
		this.msg = "sorry, there is no message";
	}

	public HelloSimple(String message) 
	{
		this.msg = message;
	}

	public void go() {
		super.go(getMessage());
		super.showName();
	}

	public String getMessage()  
	{ 
		return  msg; 
	}
}