package com.zork.api.types.toplevel.items;

import com.zork.api.types.bottomlevel.game.Game;

public class Food extends UsedOnItem {

	private int healAmount;

	public Food(String description, int bagSpace, Item makes, int healAmount,
			Tool[] useableItems) {
		super(description, bagSpace, makes, useableItems);
		this.healAmount = healAmount;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	@Override
	public void use(Tool tool) {
		Item item = this.getMakes();
		Game.getGame().getBag().remove(this);
		Game.getGame().getBag().add(item);
	}

}
