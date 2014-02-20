package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.MagicalOrb;
import com.zork.api.types.command.Command;

public class ActivateCommand extends Command {
	String item;
	
	public static Command createInstance(String string) {
		return new ActivateCommand(string);
	}

	private ActivateCommand(String item) {
		this.item = item;
	}

	@Override
	public boolean canRun() {
		return Game.getGame().getPlayer().getBag().hasItem(item)
				&& Game.getGame().getPlayer().getBag()
						.getItemForName(item) instanceof MagicalOrb;
	}

	@Override
	public void execute() {
		System.out.println("This magical orb will transport you to a random room......");
		Game.getGame()
				.getPlayer()
				.setCurrentRoom(
						((MagicalOrb) Game.getGame().getPlayer()
								.getBag().getItemForName(item))
								.getNextRoom());
		System.out.println(Game.getGame().getPlayer().getLocation());
	}

}
