package org.assume.school.projects.battleship.api.types.pegs;

import org.assume.school.projects.battleship.api.types.State.PegState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class Peg
{

	private Peg()
	{
		this(PegState.EMPTY);
	}

	public static Peg[] getInitialArray(Ship ship)
	{
		Peg[] pegs = new Peg[ship.getSize()];
		for (int i = 0; i < pegs.length; i++)
		{
			pegs[i] = new Peg();
		}
		return pegs;
	}

	private PegState state;

	public Peg(PegState state)
	{
		this.state = state;
	}

	public PegState getState()
	{
		return state;
	}

	public void setState(PegState state)
	{
		this.state = state;
	}

}
