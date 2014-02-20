package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;

public class StatsCommand extends Command {

	public static Command createInstance() {
		return new StatsCommand();
	}
	
	private StatsCommand() {
		
	}
	
	@Override
	public boolean canRun() {
		return true;
	}

	@Override
	public void execute() {
		System.out.println("Your current health is: " + Game.getGame().getPlayer().getHealth());
		if (Game.getGame().getPlayer().getWeapon() != null) {
			System.out.println("You are currently equipped with " + Game.getGame().getPlayer().getWeapon().description() + ".");
		}
		if (Game.getGame().getPlayer().isUsingAbility()) {
			System.out.println("Your current ability is " + Game.getGame().getPlayer().getAbility().getDescription());
		}
		System.out.println("Your current bagspace is " + Game.getGame().getPlayer().getBag().getSize());
		
	}
	
}
