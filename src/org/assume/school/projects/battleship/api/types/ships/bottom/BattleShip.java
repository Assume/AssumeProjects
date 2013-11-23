package org.assume.school.projects.battleship.api.types.ships.bottom;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;

public class BattleShip extends Ship
{

	public BattleShip(int size, int row, int col, int orientation,
			ShipState state)
	{
		super(size, row, col, orientation, state);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isInProbe(int leftRow, int rightRow, int bottomCol,
			int topCol)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPointsInProbe(int leftRow, int rightRowm, int bottomCol,
			int topCol)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean doesPegHit(int row, int col)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onHit(int row, int col)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
