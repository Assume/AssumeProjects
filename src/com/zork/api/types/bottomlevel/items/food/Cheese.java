package com.zork.api.types.bottomlevel.items.food;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.Knife;
import com.zork.api.types.toplevel.items.Food;
import com.zork.api.types.toplevel.items.Item;
import com.zork.api.types.toplevel.items.Tool;

public class Cheese extends Food {
	private static final String DESCRIPTION = "CHEESE that heals 3";
	private static final int HEAL_AMOUNT = 3;
	private static final Item USE_TYPE = new CheeseCubes(null);
	private static final int BAG_SPACE = 2;
	
	public String storyDescription;

	public Cheese(String storyDescription) {
		this(DESCRIPTION, BAG_SPACE, USE_TYPE, HEAL_AMOUNT);
		this.storyDescription = storyDescription;
	}

	private Cheese(String description, int bagSpace, Item makes, int healAmount) {
		super(description, bagSpace, makes, HEAL_AMOUNT, USEABLE_ITEMS);
	}

	public String getStoryDescription() {
		return storyDescription;
	}

	private static final Tool[] USEABLE_ITEMS = { new Knife(null) };

	@Override
	public void use(Tool item) {
		if (item instanceof Knife) {
			Game.getGame().getBag().remove(this).add(USE_TYPE);
		}
	}
}
