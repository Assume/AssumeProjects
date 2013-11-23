package org.assume.school.projects.battleship.api.types.ships.bottom;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class Cruiser extends Ship
{

	public static Cruiser getInstance(int row, int col, int orientation)
	{
		return new Cruiser(3, row, col, orientation, ShipState.ALIVE);
	}

	private Cruiser(int size, int row, int col, int orientation, ShipState state)
	{
		super(size, row, col, orientation, state);
	}

}
