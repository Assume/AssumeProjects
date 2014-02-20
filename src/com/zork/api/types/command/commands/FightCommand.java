package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.Abilities.SuperhumanStrength;
import com.zork.api.types.bottomlevel.npcs.fightable.DrMcCarthy;
import com.zork.api.types.command.Command;
import com.zork.api.types.interfaces.Fightable;
import com.zork.api.types.toplevel.items.Item;

public class FightCommand extends Command {

	private String monsterName;

	public static Command createInstance(String name) {
		return new FightCommand(name);
	}

	private FightCommand(String monsterName) {
		this.monsterName = monsterName;
	}

	@Override
	public boolean canRun() {
		return Game.getGame().getPlayer().getLocation()
				.hasMonster(this.monsterName);
	}

	@Override
	public void execute() {
		Fightable monster = Game.getGame().getPlayer().getLocation()
				.getMonster(this.monsterName);

		int hpLost = Math
				.abs(monster.getAttackStrength()
						- Game.getGame().getPlayer()
								.getAttackStrength(monster));
		if (Game.getGame().getPlayer().getHealth() - hpLost <= 0) {
			System.out.println("You fought " + monster
					+ " and lost! Game Over!");
			Game.getGame().getPlayer().decrementHealth(hpLost);
			Game.getGame().end();
			return;
		}
		else {
			System.out.println("You fought "
					+ monster
					+ " and won! In the course of battle, you lost "
					+ hpLost
					+ " HP and your HP is now "
					+ Game.getGame().getPlayer()
							.decrementHealth(hpLost));
			if (Game.getGame().getPlayer().isUsingAbility()
					&& Game.getGame().getPlayer().getAbility() instanceof SuperhumanStrength) {
				System.out.println("\nYour use of SUPERHUMANSTRENGTH has been used up.");
				Game.getGame().getPlayer().setAbility(null);
			}
			if (monster instanceof DrMcCarthy) {
				System.out.println("You beat Dr. McCarthy! Congratulations you have won the game!");
				Game.getGame().end();
				return;
			}
			monster.randomizeDeathDrops();
			System.out.println("Defeating the monster releases.....");
			for (Item x : monster.onDeathDrops()) {
				System.out.println("\t" + x.description() + "\n");
				Game.getGame().getPlayer().getLocation()
						.addItemToRoom(x);
			}
			System.out.println("....into the room.");
			Game.getGame().getPlayer().getLocation()
					.removeCharacter(monster);

		}
	}
}
