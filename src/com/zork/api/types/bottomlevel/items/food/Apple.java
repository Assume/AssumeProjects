package com.zork.api.types.bottomlevel.items.food;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.Knife;
import com.zork.api.types.toplevel.items.Food;
import com.zork.api.types.toplevel.items.Item;
import com.zork.api.types.toplevel.items.Tool;

public class Apple extends Food {

	private static final String DESCRIPTION = "an APPLE that heals 5";
	private static final int HEAL_AMOUNT = 5;
	private static final Item USE_TYPE = new AppleSlices("apple slices");
	private static final int BAG_SPACE = 2;
	
	private String storyDescription;

	public Apple(String storyDescription) {
		this(DESCRIPTION, BAG_SPACE, USE_TYPE, HEAL_AMOUNT);
		this.storyDescription = storyDescription;
	}

	private Apple(String description, int bagSpace, Item makes, int healAmount) {
		super(description, bagSpace, makes, HEAL_AMOUNT, USEABLE_ITEMS);
	}
	
	public String getStoryDescription() {
		return this.storyDescription;
	}

	private static final Tool[] USEABLE_ITEMS = { new Knife(null) };

	@Override
	public void use(Tool item) {
		if (item instanceof Knife) {
			Game.getGame().getBag().remove(this).add(USE_TYPE);
		}
	}

}
