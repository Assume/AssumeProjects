package org.assume.school.projects.battleship.api.types.ships.bottom;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class Submarine extends Ship
{

	public static Submarine getInstance(int row, int col, int orientation)
	{
		return new Submarine(3, row, col, orientation, ShipState.ALIVE);
	}
	
	private Submarine(int size, int row, int col, int orientation,
			ShipState state)
	{
		super(size, row, col, orientation, state);
	}

	@Override
	public boolean equals(Object o)
	{
		return o instanceof Submarine;
	}
	
}
