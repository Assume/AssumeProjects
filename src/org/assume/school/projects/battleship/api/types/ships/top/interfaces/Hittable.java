package org.assume.school.projects.battleship.api.types.ships.top.interfaces;

public interface Hittable
{

	public boolean isInProbe(int leftRow, int rightRow, int bottomCol, int topCol);
	
	public int getPointsInProbe(int leftRow, int rightRowm, int bottomCol, int topCol);
	
	public boolean doesPegHit(int row, int col);
	
	public boolean onHit(int row, int col);
	
	
}
