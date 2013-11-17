package org.assume.school.projects.lab;

public abstract class FNode extends PNode
{

	
	private PNode p1;

	public FNode(PNode p1)
	{
		this.p1 = p1;
	}

	public PNode getP1()
	{
		return p1;
	}

	public void setP1(PNode p1)
	{
		this.p1 = p1;
	}

}
