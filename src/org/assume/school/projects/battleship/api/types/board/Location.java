package org.assume.school.projects.battleship.api.types.board;

import org.assume.school.projects.battleship.api.types.State.LocationState;

public class Location
{

	
	public static Location[][] getFullGrid(int maxRow, int maxCol)
	{
		Location[][] grid = new Location[maxRow][maxCol];
 		for(int i = 0; i < maxRow; i++)
		{
			for(int j = 0; j < maxCol; j++)
			{
				grid[i][j] = new Location(i, j);
			}
		}
		return grid;
	}
	
	private final int row;
	private final int col;
	private LocationState state;

	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.state = LocationState.EMPTY;
	}

	public LocationState getState()
	{
		return state;
	}

	public void setState(LocationState state)
	{
		this.state = state;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

}
