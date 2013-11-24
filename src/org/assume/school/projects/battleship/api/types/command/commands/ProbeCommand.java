package org.assume.school.projects.battleship.api.types.command.commands;

import java.util.Scanner;

import org.assume.school.projects.battleship.api.types.command.interfaces.Commandable;
import org.assume.school.projects.battleship.api.types.users.Player;

public class ProbeCommand implements Commandable
{

    public static ProbeCommand createInstance(Player player)
    {
	try
	{
	    Scanner in = new Scanner(System.in);
	    System.out.print("Enter top row: ");
	    int topRow = in.nextInt();
	    System.out.print("Enter bottom row: ");
	    int bottomRow = in.nextInt();
	    System.out.println("Enter left column: ");
	    int leftCol = in.nextInt();
	    System.out.println("Enter right column: ");
	    int rightCol = in.nextInt();

	    bottomRow = bottomRow - topRow > 3 ? topRow + 3 : bottomRow;
	    leftCol = rightCol - leftCol > 3 ? leftCol + 3 : leftCol;

	    return new ProbeCommand(topRow, bottomRow, leftCol, rightCol,
		    player);
	} catch (Exception e)
	{
	    System.out.println("Incorrect input. Please try again.");
	    return ProbeCommand.createInstance(player);
	}

    }

    private int topRow;
    private int bottomRow;
    private int leftCol;
    private int rightCol;
    private Player player;

    public ProbeCommand(int topRow, int bottomRow, int leftCol, int rightCol,
	    Player player)
    {
	this.topRow = topRow;
	this.bottomRow = bottomRow;
	this.leftCol = leftCol;
	this.rightCol = rightCol;
	this.player = player;
    }

    @Override
    public boolean canExecute()
    {
	return true;
    }

    @Override
    public void execute()
    {
	if (player.getBoard().isProbeEmpty(topRow, bottomRow, leftCol,
		rightCol, player.getOpponent()))
	{
	    System.out
		    .println("No ship parts in probe! Better luck next time!");
	    return;
	} else
	{
	    System.out.println("Ship parts found in probe: "
		    + player.getBoard().getShipPartsInProbe(topRow, bottomRow,
			    leftCol, rightCol, player.getOpponent()));
	}

    }

}
