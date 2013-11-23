package org.assume.school.projects.battleship.api.types.ships.top.interfaces;

public interface Hittable
{

	public boolean isInProbe(int topRow, int bottomRow, int leftCol, int rightCol);
	
	public int getPointsInProbe(int topRow, int bottomRow, int leftCol, int rightCol);
	
	public boolean doesPegHit(int row, int col);
	
	public void onHit(int row, int col);
	
	
}
