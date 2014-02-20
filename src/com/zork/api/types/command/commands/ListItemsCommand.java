package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;
import com.zork.api.types.toplevel.items.Item;

public class ListItemsCommand extends Command{

	@Override
	public boolean canRun() {
		return true;
	}

	@Override
	public void execute() {
		System.out.println("You have the following items: ");
		for(Item x : Game.getGame().getBag().getItems())
		{
			System.out.println(x.getClass().getSimpleName());
		}
		
	}

	public static Command createInstance() {
		return new ListItemsCommand();
	}
	
}
