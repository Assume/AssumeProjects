package org.assume.school.projects.battleship.api.types.ships.top;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.pegs.Peg;
import org.assume.school.projects.battleship.api.types.ships.top.interfaces.Hittable;

public abstract class Ship implements Hittable
{

	public static final int HORIZONTAL = 1;
	public static final int VERTICAl = 2;

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

}
