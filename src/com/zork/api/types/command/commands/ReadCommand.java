package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.Document;
import com.zork.api.types.command.Command;

public class ReadCommand extends Command
{

    public static Command createInstance(String document)
    {
	return new ReadCommand(document);
    }

    private String document;

    private ReadCommand(String document)
    {
	this.document = document;

    }

    @Override
    public boolean canRun()
    {
	return Game.getGame().getPlayer().getLocation().hasItem(document) || Game.getGame().getPlayer().getBag().hasItem(document);
    }

    @Override
    public void execute()
    {
	if (Game.getGame().getPlayer().getLocation().getItemForName(document) instanceof Document || Game.getGame().getPlayer().getBag().getItemForName(document) instanceof Document)
	{
	    System.out.println("You read it and it says...");
	    System.out
		    .println(((Document) Game.getGame().getPlayer()
			    .getLocation().getItemForName(document))
			    .getDocumentWords());
	} else
	    System.out.println("That isn't readable.");
    }
}
