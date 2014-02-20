package com.zork.api.types.bottomlevel.npcs.fightable;

import java.util.Random;
import com.zork.api.types.bottomlevel.items.ValidItems;
import com.zork.api.types.interfaces.Fightable;
import com.zork.api.types.npcs.NPC;
import com.zork.api.types.toplevel.items.Item;

public class Orc extends NPC implements Fightable {
	int defenseLevel;
	int attackStrength;
	String description;

	public Orc(String description) {
		defenseLevel = 7;
		attackStrength = 13;
		randomizeDeathDrops();
		this.description = description;
	}

	// add items as we go. When the monster dies it will drops these
	private static Item[] onDeathDrops = new Item[5];

	public String getDescription() {
		return this.description;
	}
	
	public void randomizeDeathDrops() {
		Item[] items = ValidItems.VALID_ITEMS;
		Random r = new Random();

		for (int i = 0; i < onDeathDrops.length; i++) {
			int x = r.nextInt(items.length);
			onDeathDrops[i] = items[x];
		}
	}

	// should be between 10 and 50
	@Override
	public int getDefenseLevel() {
		return defenseLevel;
	}

	// should be between 10 and 50
	@Override
	public int getAttackStrength() {
		return attackStrength;
	}
	
	 @Override
	    public void decrementDefenseLevel(int x) {
		    defenseLevel -= x;
	    }

	@Override
	public Item[] onDeathDrops() {
		return onDeathDrops;
	}

}
