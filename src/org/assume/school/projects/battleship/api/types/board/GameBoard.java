package org.assume.school.projects.battleship.api.types.board;

import org.assume.school.projects.battleship.api.types.State.LocationState;
import org.assume.school.projects.battleship.api.types.board.interfaces.Playable;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public class GameBoard implements Playable
{

	private final Location[][] grid;

	public GameBoard()
	{
		this.grid = Location.getFullGrid(10, 10);
	}

	@Override
	public boolean isShipPlacementValid(int row, int col, int orientation,
			int size, Player player)
	{
		if (orientation == Ship.VERTICAL)
		{
			if (row + size >= this.grid.length) return false;
			for (int i = 0; i < size; i++)
			{

				if (!this.grid[row + i][col].getState().equals(
						LocationState.EMPTY)) return false;
			}
		}
		else if (orientation == Ship.HORIZONTAL)
		{
			if (col + size >= 10) return false;
			for (int i = 0; i < size; i++)
			{
				if (!this.grid[row][col + i].getState().equals(
						LocationState.EMPTY)) return false;
			}
		}
		return true;
	}

	@Override
	public boolean isAttackValid(int row, int col, Player attackee)
	{
		return false;
	}

	@Override
	public boolean isProbeEmpty(int topRow, int bottomRow, int leftCol,
			int rightCol, Player probee)
	{
		return false;
	}

	@Override
	public Ship getShipAt(int row, int col, Player probee)
	{
		return probee.getShipAt(row, col);
	}

	public Location[][] getGrid()
	{
		return grid;
	}

}
