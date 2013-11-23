package org.assume.school.projects.battleship.api.types.ships.bottom;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class AircraftCarrier extends Ship
{

	public static AircraftCarrier getInstance(int row, int col, int orientation)
	{
		return new AircraftCarrier(5, row, col, orientation, ShipState.ALIVE);
	}

	private AircraftCarrier(int size, int row, int col, int orientation,
			ShipState state)
	{
		super(size, row, col, orientation, state);
	}

}
