package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;

public class TakeCommand extends Command {

	
	public static Command createInstance(String item)
	{
		return new TakeCommand(item);
	}
	
	private String item;
	
	private TakeCommand(String item)
	{
		this.item = item;
		
	}
	
	
	@Override
	public boolean canRun() {
		return Game.getGame().getPlayer().getLocation().hasItem(item);
	}


	@Override
	public void execute() {
	if (Game.getGame().getPlayer().getBag().getSize() - Game.getGame().getPlayer().getLocation().getItemForName(item).getBagSpace() > 0) {
	    Game.getGame().getPlayer().getLocation().takeItem(this.item);
		System.out.println("You took "+this.item);
	}
	else 
		System.out.println("You don't have enough room in your bag for that item. If you really want it, remove an item of weight " + Game.getGame().getPlayer().getLocation().getItemForName(item).getBagSpace() + " or more.");
	}

}
