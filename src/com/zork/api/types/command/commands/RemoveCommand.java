package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;
import com.zork.api.types.toplevel.items.Item;

public class RemoveCommand extends Command {

	public static Command createInstance(String item) {
		return new RemoveCommand(item);
	}

	private String item;

	private RemoveCommand(String item) {
		this.item = item;

	}

	@Override
	public boolean canRun() {
		return Game.getGame().getPlayer().getBag().hasItem(item);
	}

	@Override
	public void execute() {
		Item items = Game.getGame().getPlayer().getBag().getItemForName(item);
		Game.getGame().getPlayer().getBag().removeItemForName(item);
		System.out.println("You removed "
				+ this.item
				+ " from your bag and put it back in your current room.");
		Game.getGame().getPlayer().getLocation().addItemToRoom(items);
	}
}
