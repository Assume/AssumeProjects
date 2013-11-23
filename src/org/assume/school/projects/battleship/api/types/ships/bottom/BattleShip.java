package org.assume.school.projects.battleship.api.types.ships.bottom;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class BattleShip extends Ship
{

	public static BattleShip getInstance(int row, int col, int orientation)
	{
		return new BattleShip(4, row, col, orientation, ShipState.ALIVE);
	}

	private BattleShip(int size, int row, int col, int orientation,
			ShipState state)
	{
		super(size, row, col, orientation, state);
	}
	
	@Override
	public boolean equals(Object o)
	{
		return o instanceof BattleShip;
	}

}
