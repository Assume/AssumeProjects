package com.zork.api.types.bottomlevel.items.food;

import com.zork.api.types.bottomlevel.items.Knife;
import com.zork.api.types.toplevel.items.Food;
import com.zork.api.types.toplevel.items.Item;
import com.zork.api.types.toplevel.items.Tool;

public class Bread extends Food {
	private static final int HEAL_AMOUNT = 10;
	private static final String DESCRIPTION = "a tasty loaf of BREAD that heals 10.";
	private static final Item USE_TYPE = new BreadSlices(null);
	private static final int BAG_SIZE = 4;
	private static final Tool[] USABLE_ITEMS= {new Knife(null)};
	
	private String storyDescription;
	
	public Bread(String storyDescription) {
		this (DESCRIPTION, BAG_SIZE, USE_TYPE, HEAL_AMOUNT);
		this.storyDescription = storyDescription;
	}
	
	public Bread(String description, int healAmount, Item useType, int bagSize) {
		super(description, bagSize, useType, HEAL_AMOUNT, USABLE_ITEMS);
	}
	
	public String getStoryDescription() {
		return this.storyDescription;
	}
	
	
	@Override
	public void use(Tool tool) {
		
	}
	

}
