package com.zork.api.types.bottomlevel.items;

import com.zork.api.types.bottomlevel.items.Abilities.Abilities;
import com.zork.api.types.bottomlevel.items.Abilities.BlowFireAbility;
import com.zork.api.types.bottomlevel.items.food.Apple;
import com.zork.api.types.bottomlevel.items.food.AppleSlices;
import com.zork.api.types.bottomlevel.items.food.Bread;
import com.zork.api.types.bottomlevel.items.food.BreadSlices;
import com.zork.api.types.bottomlevel.items.food.Cheese;
import com.zork.api.types.bottomlevel.items.food.CheeseCubes;
import com.zork.api.types.bottomlevel.items.weapon.Sword;
import com.zork.api.types.bottomlevel.items.weapon.Torch;
import com.zork.api.types.toplevel.items.Item;

public class ValidItems {
	//array of items for randomizing death drops
	public static final Abilities[] VALID_ABILITIES = new Abilities[] {new BlowFireAbility()};
	public static final Item[] VALID_ITEMS= new Item[] {new Apple(""), new AppleSlices(""), new Bread(""), new BreadSlices(""), new Cheese(""), new CheeseCubes(""), new Knife(""), new Sword(""), new Torch("")};
}
