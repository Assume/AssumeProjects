package org.assume.school.projects.battleship.api.types.ships.bottom;

import java.util.Scanner;

import org.assume.school.projects.battleship.api.types.State.ShipState;
import org.assume.school.projects.battleship.api.types.ships.top.Ship;
import org.assume.school.projects.battleship.api.types.users.Player;

public class AircraftCarrier extends Ship
{

	public static void getInstance(boolean fail, Player p)
	{
		if(fail)
			System.out.println("Invalid location");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter row location for Aircraft Carrier: ");
		int row = in.nextInt();
		System.out.println();
		System.out.print("Enter column location for Aircraft Carrier: ");
		int col = in.nextInt();
		System.out.println();
		System.out.print("Enter orientation (1 for horizontal, 2 for vertical)");
		int or = in.nextInt();
		if(p.addShip(new AircraftCarrier(5, row, col, or, ShipState.ALIVE)))
			return;
		else
			getInstance(true, p);
	}

	private AircraftCarrier(int size, int row, int col, int orientation,
			ShipState state)
	{
		super(size, row, col, orientation, state);
	}

	@Override
	public boolean equals(Object o)
	{
		return o instanceof AircraftCarrier;
	}
	
}
