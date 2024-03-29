package org.assume.school.projects.battleship.api.types.ships.bottom;

import java.util.Scanner;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public class Cruiser extends Ship
{

    public static void createInstance(Player p)
    {
	try
	{
	    Scanner in = new Scanner(System.in);
	    System.out.print("Would you like to print your board[Player "
		    + p.getName() + "]? (y/n): ");
	    String ys = in.nextLine();
	    if (ys.equalsIgnoreCase("y"))
		System.out.println(p.toString());
	    System.out.println("Cruiser length: 3");
	    System.out.print("Enter row location for Cruiser: ");
	    int row = in.nextInt();
	    System.out.print("Enter column location for Cruiser: ");
	    int col = in.nextInt();
	    System.out
		    .print("Enter orientation (1 for horizontal, 2 for vertical): ");
	    int or = in.nextInt();
	    if (p.addShip(new Cruiser(3, row, col, or, ShipState.ALIVE)))
		return;
	    else
		createInstance(p);
	} catch (Exception e)
	{
	    System.out
		    .println("Incorrect input. Restarting boat creation for: Cruiser");
	    createInstance(p);
	}
    }

    private Cruiser(int size, int row, int col, int orientation, ShipState state)
    {
	super(size, row, col, orientation, state);
    }

    @Override
    public boolean equals(Object o)
    {
	return o instanceof Cruiser;
    }

}
