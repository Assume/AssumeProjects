package org.assume.school.projects.battleship.api.types.command.commands;

import java.util.Scanner;

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

    public static MoveCommand createInstance(Player player)
    {
	try
	{

	    Scanner in = new Scanner(System.in);
	    System.out
		    .print("Choose Ship to move: \n 1. Aircraft Carrier \n 2. Battleship \n 3. Submarine \n 4. Cruiser \n 5. Destroyer");
	    Ship ship = player.getShips().get(in.nextInt() - 1);
	    System.out
		    .print("Choose direction: \n 1. Up\n 2. Down\n 3. Left \n 4. Right");
	    int dir = in.nextInt();

	    MoveCommand move = new MoveCommand(dir, ship, player);
	    if (move.canExecute())
		return move;
	    else
	    {
		System.out.println("Move not valid. Please try again");
		return MoveCommand.createInstance(player);
	    }
	} catch (Exception e)
	{
	    System.out.println("Incorrect input. Please try again.");
	    return MoveCommand.createInstance(player);
	}
    }

    private int direction;
    private Ship ship;
    private Player player;

    private MoveCommand(int direction, Ship ship, Player player)
    {
	this.direction = direction;
	this.ship = ship;
	this.player = player;
    }

    private boolean canExecuteUp()
    {
	if (this.ship.getOrientation() == Ship.VERTICAL)
	{
	    return ((this.ship.getRow() - 1) >= 0)
		    && player.getBoard().getGrid()[ship.getRow() - 1][ship
			    .getCol()].getState().equals(LocationState.EMPTY);
	} else if (this.ship.getOrientation() == Ship.HORIZONTAL)
	{
	    if ((this.ship.getRow() - 1) < 0)
		return false;
	    for (int i = 0; i < this.ship.getSize(); i++)
	    {
		if (!this.player.getBoard().getGrid()[this.ship.getRow() - 1][this.ship
			.getCol() + i].getState().equals(LocationState.EMPTY))
		    return false;
	    }
	}
	return true;
    }

    private boolean canExecuteDown()
    {
	if (this.ship.getOrientation() == Ship.VERTICAL)
	{
	    return ((this.ship.getRow() + ship.getSize() + 1) <= 9)
		    && player.getBoard().getGrid()[ship.getRow()
			    + ship.getSize() + 1][ship.getCol()].getState()
			    .equals(LocationState.EMPTY);
	} else if (this.ship.getOrientation() == Ship.HORIZONTAL)
	{
	    if ((this.ship.getRow() - 1) < 0)
		return false;
	    for (int i = 0; i < this.ship.getSize(); i++)
	    {
		if (!this.player.getBoard().getGrid()[this.ship.getRow() + 1][this.ship
			.getCol() + i].getState().equals(LocationState.EMPTY))
		    return false;
	    }
	}
	return true;
    }

    @Override
    public boolean canExecute()
    {
	if (this.direction == UP)
	{
	    return this.canExecuteUp();
	} else if (this.direction == DOWN)
	{
	    return this.canExecuteDown();
	} else if (this.direction == RIGHT)
	    return ((this.ship.getCol() + ship.getSize() + 1) <= 9)
		    && player.getBoard().getGrid()[ship.getRow()][ship.getCol()
			    + ship.getSize() + 1].getState().equals(
			    LocationState.EMPTY);
	else if (this.direction == LEFT)
	    return ((this.ship.getCol() - 1) >= 0)
		    && player.getBoard().getGrid()[ship.getRow()][ship.getCol()
			    + -1].getState().equals(LocationState.EMPTY);
	return false;
    }

    @Override
    public void execute()
    {
	if (!canExecute())
	    return;

	if (this.direction == UP)
	{
	    ship.setRow(ship.getRow() - 1);
	    this.player.getBoard().moveShip(this.ship, direction);
	} else if (this.direction == DOWN)
	{
	    ship.setRow(ship.getRow() + 1);
	    this.player.getBoard().moveShip(this.ship, direction);
	} else if (this.direction == RIGHT)
	{
	    ship.setCol(ship.getCol() + 1);
	    this.player.getBoard().moveShip(this.ship, direction);
	} else if (this.direction == LEFT)
	{
	    ship.setCol(ship.getCol() - 1);
	    this.player.getBoard().moveShip(this.ship, direction);
	}
    }

}
