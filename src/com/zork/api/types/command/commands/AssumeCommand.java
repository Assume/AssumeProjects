package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.Abilities.Abilities;
import com.zork.api.types.command.Command;

public class AssumeCommand extends Command {
	String ability;

	public static Command createInstance(String ability) {
		return new AssumeCommand(ability);
	}

	private AssumeCommand(String ability) {
		this.ability = ability;
	}

	@Override
	public boolean canRun() {
		return (Game.getGame().getPlayer().getLocation()
				.hasAbility(ability));
	}

	@Override
	public void execute() {
		if (Game.getGame().getPlayer().isUsingAbility()) {
			Abilities newAbility = Game.getGame().getPlayer()
					.getLocation().getAbilityForName(ability);
			Abilities currentAbility = Game.getGame().getPlayer()
					.getAbility();

			System.out.println("To assume this ability, you release your "
					+ currentAbility.getClass().getSimpleName()
					+ " into the current room.");
			Game.getGame().getPlayer().getLocation()
					.addAbilityToRoom(currentAbility);
			Game.getGame().getPlayer().getLocation()
					.removeAbilityFromRoom(newAbility);
			Game.getGame().getPlayer().setAbility(newAbility);
		}
		else {
			Game.getGame()
					.getPlayer()
					.setAbility(Game.getGame().getPlayer()
							.getLocation()
							.getAbilityForName(ability));
			Game.getGame()
					.getPlayer()
					.getLocation()
					.removeAbilityFromRoom(
							Game.getGame()
									.getPlayer()
									.getLocation()
									.getAbilityForName(
											ability));
		}
	}

}
