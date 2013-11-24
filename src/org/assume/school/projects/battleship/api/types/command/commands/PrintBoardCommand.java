package org.assume.school.projects.battleship.api.types.command.commands;

import org.assume.school.projects.battleship.api.types.command.interfaces.Commandable;
import org.assume.school.projects.battleship.api.types.users.Player;

public class PrintBoardCommand implements Commandable
{

    public static PrintBoardCommand createInstance(Player player)
    {
	return new PrintBoardCommand(player);
    }

    private Player player;

    private PrintBoardCommand(Player player)
    {
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
	System.out.println(player);
    }

}
