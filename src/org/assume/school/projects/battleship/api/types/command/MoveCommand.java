package org.assume.school.projects.battleship.api.types.command;

import org.assume.school.projects.battleship.api.types.State.LocationState;
import org.assume.school.projects.battleship.api.types.command.interfaces.Commandable;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public class MoveCommand implements Commandable
{

	public static final int UP = 1;
	public static final int DOWN = 2;

	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	private int direction;
	private Ship ship;
	private Player player;

	public MoveCommand(int direction, Ship ship, Player player)
	{
		this.direction = direction;
		this.ship = ship;
		this.player = player;
	}

	@Override
	public boolean canExecute()
	{
		if (this.direction == UP)
			return ((ship.getRow() - 1) >= 0) && player.getBoard().getGrid()[ship.getRow() - 1][ship.getCol()].getState().equals(LocationState.EMPTY);
		else if (this.direction == DOWN)
			return ((ship.getRow() + 1) <= 9) && player.getBoard().getGrid()[ship.getRow() + 1][ship.getCol()].getState().equals(LocationState.EMPTY);
		else if (this.direction == RIGHT)
			return ((ship.getCol() + 1) <= 9) && player.getBoard().getGrid()[ship.getRow()][ship.getCol() + 1].getState().equals(LocationState.EMPTY);
		else if (this.direction == LEFT)
			return ((ship.getCol() - 1) >= 0) && player.getBoard().getGrid()[ship.getRow()][ship.getCol() + -1].getState().equals(LocationState.EMPTY);
		return false;
	}

	@Override
	public void execute()
	{
		if (!canExecute()) return;

		if (this.direction == UP)
		{
			ship.setRow(ship.getRow() - 1);
			this.player.getBoard().moveShip(this.ship, direction);
		}
		else if (this.direction == DOWN)
		{
			ship.setRow(ship.getRow() + 1);
			this.player.getBoard().moveShip(this.ship, direction);
		}
		else if (this.direction == RIGHT)
		{
			ship.setCol(ship.getCol() + 1);
			this.player.getBoard().moveShip(this.ship, direction);
		}
		else if (this.direction == LEFT)
		{
			ship.setCol(ship.getCol() - 1);
			this.player.getBoard().moveShip(this.ship, direction);
		}
	}

}
