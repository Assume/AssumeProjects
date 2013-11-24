package org.assume.school.projects.battleship.api.types.board.interfaces;

import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public interface Playable
{

	public String isShipPlacementValid(int row, int col, int orientation, int size);
	
	public boolean isAttackValid(int row, int col, Player attackee);
	
	public boolean isProbeEmpty(int topRow, int bottomRow, int leftCol, int rightCol, Player probee);
	
	public int getShipPartsInProbe(int topRow, int bottomRow, int leftCol, int rightCol, Player probee);
	
	public void addShip(Ship s);
	
	public Ship getShipAt(int row, int col, Player probee);
	
	public void onHit(int row, int col);
	
	public void onMiss(int row, int col);
	
	public boolean isCodeValid(String code);
	
	public void moveShip(Ship ship, int direction);
	
	
}
