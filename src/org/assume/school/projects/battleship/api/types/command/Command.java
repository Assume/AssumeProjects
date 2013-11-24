package org.assume.school.projects.battleship.api.types.command;

import java.util.Scanner;

import org.assume.school.projects.battleship.api.types.command.commands.AttackCommand;
import org.assume.school.projects.battleship.api.types.command.commands.MoveCommand;
import org.assume.school.projects.battleship.api.types.command.commands.PrintBoardCommand;
import org.assume.school.projects.battleship.api.types.command.commands.ProbeCommand;
import org.assume.school.projects.battleship.api.types.command.interfaces.Commandable;
import org.assume.school.projects.battleship.api.types.users.Player;

public class Command
{

    public static final String ATTACK_STRING = "attack";
    public static final int ATTACK_INT = 1;

    public static final String PROBE_STRING = "probe";
    public static final int PROBE_INT = 2;

    public static final String MOVE_STRING = "move";
    public static final int MOVE_INT = 3;
    
    public static final String PRINT_OWN_BOARD_STRING = "own board";
    public static final int PRINT_OWN_BOARD_INT = 4;

    public static final String ORIENTATION_CHANGE_STRING = "orientation";
    public static final int ORIENTATION_CHANGE = 5;

    public static Commandable getCommand(Player player)
    {
	try
	{
	    Scanner in = new Scanner(System.in);
	    System.out.print("Choose a command(" + player.getName()
		    + "): \n 1. Attack \n 2. Probe \n 3. Move Ship \n 4. Print your board");
	    int com = in.nextInt();
	    if (Command.isCommandValid(com))
	    {
		return Command.createCommand(com, player);
	    } else
	    {
		System.out.println("Invalid input. Please try again");
		return Command.getCommand(player);
	    }
	} catch (Exception e)
	{
	    System.out.println("Input incorrect. Try again");
	    return Command.getCommand(player);
	}

    }

    private static Commandable createCommand(int com, Player player)
    {
	switch (com)
	{
	case 1:
	    return AttackCommand.createInstance(player);
	case 2:
	    return ProbeCommand.createInstance(player);
	case 3:
	    return MoveCommand.createInstance(player);
	case 4: 
	    return PrintBoardCommand.createInstance(player);
	}
	return null;
    }

    public static boolean isCommandValid(int command)
    {
	return command == Command.ATTACK_INT || command == Command.PROBE_INT
		|| command == Command.MOVE_INT || command  == Command.PRINT_OWN_BOARD_INT;
    }
}
