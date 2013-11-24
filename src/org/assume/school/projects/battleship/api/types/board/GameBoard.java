package org.assume.school.projects.battleship.api.types.board;

import org.assume.school.projects.battleship.api.types.State.LocationState;
import org.assume.school.projects.battleship.api.types.board.interfaces.Playable;
import org.assume.school.projects.battleship.api.types.command.commands.MoveCommand;
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
	} else if (orientation == Ship.HORIZONTAL)
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
	    if (s.doesPegHit(row, col, attackee.getBoard()))
		return true;
	}
	return false;
    }

    @Override
    public boolean isProbeEmpty(int topRow, int bottomRow, int leftCol,
	    int rightCol, Player probee)
    {
	for (Ship s : probee.getShips())
	{
	    if (s.isInProbe(topRow, bottomRow, leftCol, rightCol))
		return false;
	}
	return true;
    }

    @Override
    public int getShipPartsInProbe(int topRow, int bottomRow, int leftCol,
	    int rightCol, Player probee)
    {
	int total = 0;
	for (Ship s : probee.getShips())
	{
	    total += s.getPointsInProbe(topRow, bottomRow, leftCol, rightCol);
	}
	return total;
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
	} else if (s.getOrientation() == Ship.HORIZONTAL)
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

    private void moveShipUp(Ship ship)
    {
	if (ship.getOrientation() == Ship.VERTICAL)
	{
	    for (int i = ship.getRow(); i < ship.getRow() + ship.getSize(); i++)
		this.grid[i][ship.getCol()].setState(this.grid[i + 1][ship
			.getCol()].getState());
	    this.grid[ship.getRow() + ship.getSize()][ship.getCol()]
		    .setState(LocationState.EMPTY);
	} else if (ship.getOrientation() == Ship.HORIZONTAL)
	{
	    for (int i = ship.getCol(); i < ship.getCol() + ship.getSize(); i++)
		this.grid[ship.getRow()][i]
			.setState(this.grid[ship.getRow() + 1][ship.getCol()]
				.getState());
	    for (int i = ship.getCol(); i < ship.getCol() + ship.getSize(); i++)
		this.grid[ship.getRow() + 1][i].setState(LocationState.EMPTY);
	}
    }

    private void moveShipDown(Ship ship)
    {
	if (ship.getOrientation() == Ship.VERTICAL)
	{
	    for (int i = ship.getRow(); i < ship.getRow() + ship.getSize(); i++)
		this.grid[i][ship.getCol()].setState(this.grid[i - 1][ship
			.getCol()].getState());
	    this.grid[ship.getRow() - 1][ship.getCol()]
		    .setState(LocationState.EMPTY);
	} else if (ship.getOrientation() == Ship.HORIZONTAL)
	{
	    for (int i = ship.getCol(); i < ship.getCol() + ship.getSize(); i++)
		this.grid[ship.getRow()][i]
			.setState(this.grid[ship.getRow() - 1][ship.getCol()]
				.getState());
	    for (int i = ship.getCol(); i < ship.getCol() + ship.getSize(); i++)
		this.grid[ship.getRow() - 1][i].setState(LocationState.EMPTY);
	}

    }

    private void moveShipRight(Ship ship)
    {
	if (ship.getOrientation() == Ship.VERTICAL)
	{
	    for (int i = ship.getRow(); i < ship.getCol() + ship.getSize(); i++)
		this.grid[i][ship.getCol()]
			.setState(this.grid[i][ship.getCol() - 1].getState());
	    for (int i = ship.getRow(); i < ship.getRow() + ship.getSize(); i++)
		this.grid[i][ship.getCol() - 1].setState(LocationState.EMPTY);
	} else if (ship.getOrientation() == Ship.HORIZONTAL)
	{
	    for (int i = ship.getCol(); i < ship.getCol() + ship.getSize() - 1; i++)
		this.grid[ship.getRow()][i + 1].setState(this.grid[ship
			.getRow()][i - 1].getState());
	    this.grid[ship.getRow()][ship.getCol() - 1]
		    .setState(LocationState.EMPTY);
	}
    }

    private void moveShipLeft(Ship ship)
    {
	if (ship.getOrientation() == Ship.VERTICAL)
	{
	    for (int i = ship.getRow(); i < ship.getCol() + ship.getSize() + 1; i++)
		this.grid[i][ship.getCol()]
			.setState(this.grid[i][ship.getCol() + 1].getState());
	    for (int i = ship.getRow(); i < ship.getRow() + ship.getSize(); i++)
		this.grid[i][ship.getCol() + 1].setState(LocationState.EMPTY);
	} else if (ship.getOrientation() == Ship.HORIZONTAL)
	{
	    for (int i = ship.getCol(); i < ship.getCol() + ship.getSize(); i++)
		this.grid[ship.getRow()][i]
			.setState(this.grid[ship.getRow()][i + 1].getState());
	    this.grid[ship.getRow()][ship.getCol() + ship.getSize()]
		    .setState(LocationState.EMPTY);
	}
    }

    @Override
    public void moveShip(Ship ship, int direction)
    {
	if (direction == MoveCommand.UP)
	{
	    this.moveShipUp(ship);

	} else if (direction == MoveCommand.DOWN)
	{
	    this.moveShipDown(ship);
	} else if (direction == MoveCommand.RIGHT)
	{
	    this.moveShipRight(ship);
	} else if (direction == MoveCommand.LEFT)
	{
	    this.moveShipLeft(ship);
	}

    }

}
