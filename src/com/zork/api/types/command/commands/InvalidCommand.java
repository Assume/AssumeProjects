package com.zork.api.types.command.commands;

import com.zork.api.types.command.Command;

public class InvalidCommand extends Command
{

    public static Command createInstance()
    {
	return new InvalidCommand();

    }

    private InvalidCommand()
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
    }

}
