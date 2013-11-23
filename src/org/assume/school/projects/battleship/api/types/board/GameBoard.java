package org.assume.school.projects.battleship.api.types.board;

import org.assume.school.projects.battleship.api.types.State.LocationState;
import org.assume.school.projects.battleship.api.types.board.interfaces.Playable;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public class GameBoard implements Playable
{

	public static void main(String[] args)
	{
		/*Player p = new Player("Adam");
		Player p2 = new Player("Roy");

		p.setOpponent(p2);
		p2.setOpponent(p);
		p.addShip(BattleShip.getInstance(3, 2, Ship.VERTICAL));
		p.addShip(AircraftCarrier.getInstance(0, 5, Ship.VERTICAL));
		p.addShip(Cruiser.getInstance(2, 8, Ship.VERTICAL));

		p2.addShip(BattleShip.getInstance(3, 2, Ship.VERTICAL));
		p2.addShip(AircraftCarrier.getInstance(0, 5, Ship.VERTICAL));
		p2.addShip(Cruiser.getInstance(2, 8, Ship.VERTICAL));

		p.attack(3, 2);
		p.attack(4, 2);
		p.attack(5, 2);
		p.attack(6, 2);

		System.out.println(p);
		System.out.println(p2);*/
	}

	private final Location[][] grid;

	public GameBoard()
	{
		this.grid = Location.getFullGrid(10, 10);
	}

	@Override
	public boolean isShipPlacementValid(int row, int col, int orientation,
			int size)
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
		for (Ship s : attackee.getShips())
		{
			if (s.doesPegHit(row, col, this)) return true;
		}
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

	@Override
	public void addShip(Ship s)
	{
		if (s.getOrientation() == Ship.VERTICAL)
		{
			for (int i = 0; i < s.getSize(); i++)
			{
				this.grid[s.getRow() + i][s.getCol()]
						.setState(LocationState.SHIP_PART);
				;
			}
		}
		else if (s.getOrientation() == Ship.HORIZONTAL)
		{
			for (int i = 0; i < s.getSize(); i++)
			{
				this.grid[s.getRow()][s.getCol() + i]
						.setState(LocationState.SHIP_PART);
			}
		}
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("B ");
		for (int i = 0; i < 10; i++)
			builder.append(i + " ");
		builder.append("\n");
		for (int i = 0; i < 10; i++)
		{
			builder.append(i);
			for (int j = 0; j < 10; j++)
			{
				builder.append(" " + this.grid[i][j].getState().getChar());
			}
			builder.append("\n");
		}

		return builder.toString();
	}

	@Override
	public void onHit(int row, int col)
	{
		this.grid[row][col].setState(LocationState.SHIP_HIT);

	}

	@Override
	public void onMiss(int row, int col)
	{
		this.grid[row][col].setState(LocationState.PEG);

	}

}
