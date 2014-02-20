package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;

public class GoCommand extends Command
{
    String direction;

    public static Command createInstance(String dir)
    {
	return new GoCommand(dir);
    }

    private GoCommand(String direction)
    {
	this.direction = direction;
    }

    @Override
    public boolean canRun()
    {
	return Game.getGame().getPlayer().getLocation().hasDoor(direction);
    }

    @Override
    public void execute()
    {
	if (Game.getGame().getPlayer().getLocation().getDoor(direction)
		.isOpen())
	{
	    Game.getGame()
		    .getPlayer()
		    .setCurrentRoom(
			    Game.getGame().getPlayer().getLocation()
				    .getDoor(direction).getNextRoom());
	    System.out.println(Game.getGame().getPlayer().getLocation());
	} else
	{
	    System.out.println("The door is not open.");
	}

    }

}
