package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;

public class QuitCommand extends Command
{

    public static Command createInstance()
    {
	return new QuitCommand();
    }

    private QuitCommand()
    {

    }

    @Override
    public boolean canRun()
    {
	return true;
    }

    @Override
    public void execute()
    {
	Game.getGame().end();
	System.out.println("bye");
    }

}
