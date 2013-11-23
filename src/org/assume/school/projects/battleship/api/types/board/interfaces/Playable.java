package org.assume.school.projects.battleship.api.types.board.interfaces;

import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public interface Playable
{

	public boolean isShipPlacementValid(int row, int col, int orientation, int size, Player player);
	
	public boolean isAttackValid(int row, int col, Player attackee);
	
	public boolean isProbeEmpty(int topRow, int bottomRow, int leftCol, int rightCol, Player probee);
	
	public Ship getShipAt(int row, int col, Player probee);
	
	
}
