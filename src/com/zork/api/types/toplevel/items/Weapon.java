package com.zork.api.types.toplevel.items;

public class Weapon extends Item {
	private int strength;

	public Weapon(String description, int bagSpace, int strength) {
		super(description, bagSpace);
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}

}
