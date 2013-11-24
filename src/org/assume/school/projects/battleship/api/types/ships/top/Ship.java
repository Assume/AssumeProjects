package org.assume.school.projects.battleship.api.types.ships.top;

import org.assume.school.projects.battleship.api.types.State.LocationState;
import org.assume.school.projects.battleship.api.types.State.PegState;
import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.board.GameBoard;
import org.assume.school.projects.battleship.api.types.pegs.Peg;
import org.assume.school.projects.battleship.api.types.ships.top.interfaces.Hittable;

public class Ship implements Hittable
{

    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;

    private final int size;
    private final Peg[] pegs;

    private int row;
    private int col;

    private int orientation;
    private ShipState state;

    private int pegsHit;

    public Ship(int size, int row, int col, int orientation, ShipState state)
    {
	this.size = size;
	this.row = row;
	this.col = col;
	this.orientation = orientation;
	this.state = state;
	this.pegsHit = 0;
	this.pegs = Peg.getInitialArray(this);
    }

    public int getSize()
    {
	return size;
    }

    public int getRow()
    {
	return row;
    }

    public void setRow(int row)
    {
	this.row = row;
    }

    public int getCol()
    {
	return col;
    }

    public void setCol(int col)
    {
	this.col = col;
    }

    public int getOrientation()
    {
	return orientation;
    }

    public void setOrientation(int orientation)
    {
	this.orientation = orientation;
    }

    public ShipState getShipState()
    {
	return state;
    }

    public void setShipState(ShipState state)
    {
	this.state = state;
    }

    public int getPegsHit()
    {
	return pegsHit;
    }

    public void setPegsHit(int pegsHit)
    {
	this.pegsHit = pegsHit;
    }

    public Peg[] getPegs()
    {
	return pegs;
    }

    @Override
    public boolean isInProbe(int topRow, int bottomRow, int leftCol,
	    int rightCol)
    {
	if (this.orientation == Ship.VERTICAL)
	{
	    if (this.getCol() < leftCol && this.getCol() > rightCol)
		return false;
	    for (int i = 0; i < this.getSize(); i++)
	    {
		int row = this.getRow() - i;
		if (row <= topRow && row >= bottomRow)
		    return true;
	    }
	} else if (this.orientation == Ship.HORIZONTAL)
	{
	    if (this.getRow() > topRow && this.getRow() < bottomRow)
		return false;
	    for (int i = 0; i < this.getSize(); i++)
	    {
		int col = this.getCol() + i;
		if (col >= leftCol && col <= rightCol)
		    return true;
	    }
	}
	return false;
    }

    @Override
    public int getPointsInProbe(int topRow, int bottomRow, int leftCol,
	    int rightCol)
    {
	int total = 0;
	if (!isInProbe(topRow, bottomRow, leftCol, rightCol))
	    return 0;
	else
	{
	    if (this.orientation == Ship.VERTICAL)
	    {
		for (int i = 0; i < this.getSize(); i++)
		{
		    int row = this.getRow() - i;
		    if (row <= topRow && row >= bottomRow)
			total++;
		}
	    } else if (this.orientation == Ship.HORIZONTAL)
	    {
		for (int i = 0; i < this.getSize(); i++)
		{
		    int col = this.getCol() + i;
		    if (col >= leftCol && col <= rightCol)
			total++;
		}
	    }
	}
	return total;
    }

    @Override
    public boolean isOnShip(int row, int col)
    {
	if (this.getOrientation() == Ship.VERTICAL)
	{
	    return row <= this.row && row >= (this.row + this.size) && this.col == col;
	} else if (this.getOrientation() == Ship.HORIZONTAL)
	{
	    return row == this.row && col <= (this.col + this.size) && col >= this.col;
	}
	return false;
    }

    @Override
    public boolean doesPegHit(int row, int col, GameBoard board)
    {
	return board.getGrid()[row][col].getState().equals(
		LocationState.SHIP_PART);
    }

    @Override
    public void onHit(int row, int col)
    {
	if (this.orientation == Ship.VERTICAL)
	    this.pegs[row - this.row].setState(PegState.HIT);
	else if (this.orientation == Ship.HORIZONTAL)
	    this.pegs[col - this.col].setState(PegState.HIT);
	this.pegsHit++;
	if (this.getPegsLeft() == 0)
	    this.setShipState(ShipState.DEAD);
    }

    @Override
    public int getPegsLeft()
    {
	return this.size - this.pegsHit;
    }

    @Override
    public boolean isSunk()
    {
	return this.getShipState().equals(ShipState.DEAD);
    }

    @Override
    public String toString()
    {
	return this.getClass().getSimpleName();
    }

}
