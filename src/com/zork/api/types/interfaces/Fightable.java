package com.zork.api.types.interfaces;

import com.zork.api.types.toplevel.items.Item;

public interface Fightable {

	public String getDescription();
	// should be between 10 and 50
	public int getDefenseLevel();
	
	public void randomizeDeathDrops();

	// should be between 10 and 50
	public int getAttackStrength();

	public Item[] onDeathDrops();

	public void decrementDefenseLevel(int x);

}
