package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;
import com.zork.api.types.toplevel.items.Food;

public class EatCommand extends Command {

	private String item;

	public static Command createInstance(String name) {
		return new EatCommand(name);
	}

	private EatCommand(String item) {
		this.item = item;
	}

	@Override
	public boolean canRun() {
		return Game.getGame().getBag().hasItem(this.item)
				&& Game.getGame().getBag().getItemForName(this.item) instanceof Food;
	}

	@Override
	public void execute() {
		Game.getGame()
				.getPlayer()
				.incrementHealth(
						((Food) Game.getGame().getBag()
								.getItemForName(this.item))
								.getHealAmount());
		System.out.println("You ate the " + this.item
				+ " and it healed you to "
				+ Game.getGame().getPlayer().getHealth() + " health");
		Game.getGame().getBag().removeItemForName(this.item);
	}

}
