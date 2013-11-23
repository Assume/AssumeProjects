package org.assume.school.projects.battleship.api.types.ships.bottom;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class Destroyer extends Ship
{

	public static Destroyer getInstance(int row, int col, int orientation)
	{
		return new Destroyer(2, row, col, orientation, ShipState.ALIVE);
	}

	private Destroyer(int size, int row, int col, int orientation,
			ShipState state)
	{
		super(size, row, col, orientation, state);
	}

}
