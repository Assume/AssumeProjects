package org.assume.school.projects.battleship.api.types.board;

import org.assume.school.projects.battleship.api.types.State.LocationState;
import org.assume.school.projects.battleship.api.types.board.interfaces.Playable;
import org.assume.school.projects.battleship.api.types.command.MoveCommand;
import org.assume.school.projects.battleship.api.types.ships.bottom.AircraftCarrier;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public class GameBoard implements Playable
{

	public static void main(String[] args)
	{

		Player p = new Player("Adam");
		Player p2 = new Player("Roy");

		p.setOpponent(p2);
		p2.setOpponent(p);
		AircraftCarrier.createInstance(p);
		System.out.println(p);
		p.executeCommand(new MoveCommand(MoveCommand.UP, p.getShips().get(0), p));
		System.out.println(p);

	}

	private final Location[][] grid;

	public GameBoard()
	{
		this.grid = Location.getFullGrid(10, 10);
	}

	@Override
	public String isShipPlacementValid(int row, int col, int orientation,
			int size)
	{
		if (orientation == Ship.VERTICAL)
		{
			if (row + size > this.grid.length)
				return "Invalid. Ship will be off board! loc[r" + row + ",c"
						+ col + "]";
			for (int i = 0; i < size; i++)
			{
				if (!this.grid[row + i][col].getState().equals(
						LocationState.EMPTY))
					return "Invalid. Space already taken by other ship! loc[r"
							+ row + ",c" + col + "]";
			}
		}
		else if (orientation == Ship.HORIZONTAL)
		{
			if (col + size > 10)
				return "Invalid. Ship will be off board! loc[r" + row + ",c"
						+ col + "]";
			for (int i = 0; i < size; i++)
			{
				if (!this.grid[row][col + i].getState().equals(
						LocationState.EMPTY))
					return "Invalid. Space already taken by other ship! loc[r"
							+ row + ",c" + col + "]";
			}
		}
		return "Valid";
	}

	@Override
	public boolean isCodeValid(String code)
	{
		return code.equals("Valid");
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

	@Override
	public void moveShip(Ship ship, int direction)
	{
		if (direction == MoveCommand.UP)
		{
			for (int i = ship.getRow(); i < ship.getRow() + ship.getSize(); i++)
				this.grid[i][ship.getCol()].setState(this.grid[i + 1][ship
						.getCol()].getState());
			this.grid[ship.getRow() + ship.getSize()][ship.getCol()]
					.setState(LocationState.EMPTY);
		}
		else if (direction == MoveCommand.DOWN)
			for (int i = ship.getRow(); i < ship.getRow() + ship.getSize(); i++)
				this.grid[i][ship.getCol()].setState(this.grid[i - 1][ship
						.getCol()].getState());
	}

}
