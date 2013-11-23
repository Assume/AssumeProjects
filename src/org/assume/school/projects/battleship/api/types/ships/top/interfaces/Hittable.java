package org.assume.school.projects.battleship.api.types.ships.top.interfaces;

import org.assume.school.projects.battleship.api.types.board.GameBoard;

public interface Hittable
{

	public boolean isInProbe(int topRow, int bottomRow, int leftCol, int rightCol);
	
	public int getPointsInProbe(int topRow, int bottomRow, int leftCol, int rightCol);
	
	public boolean doesPegHit(int row, int col, GameBoard board);
	
	public void onHit(int row, int col);
	
	public int getPegsLeft();
	
	public boolean isSunk();
	
	public boolean isOnShip(int row, int col);
	
}
