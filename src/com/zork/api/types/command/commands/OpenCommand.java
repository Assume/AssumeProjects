package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;

public class OpenCommand extends Command
{
    public static Command createInstance(String direction)
    {
	return new OpenCommand(direction);
    }

    private String direction;

    private OpenCommand(String direction)
    {
	this.direction = direction;
    }

    @Override
    public boolean canRun()
    {
	return Game.getGame().getPlayer().getLocation().hasDoor(direction) && !Game.getGame().getPlayer().getLocation().getDoor(direction)
		.isOpen();
    }

    @Override
    public void execute()
    {
	Game.getGame().getPlayer().getLocation().getDoor(direction)
		.setOpen(true);

	System.out.println("The " + direction + " door is now open.");
    }
}
