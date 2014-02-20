package com.zork.api.types.toplevel.items;

import java.util.Arrays;
import java.util.List;

public abstract class UsedOnItem extends Item {

	public final Item makes;
	private final List<Tool> USEABLE_ITEMS;

	public UsedOnItem(String description, int bagSpace, Item makes,
			Tool[] useableItems) {
		super(description, bagSpace);
		this.makes = makes;
		this.USEABLE_ITEMS = Arrays.asList(useableItems);
	}

	public boolean isUsable(Tool tool) {
		return this.USEABLE_ITEMS.contains(tool);
	}

	public abstract void use(Tool tool);

	public Item getMakes() {
		return makes;
	}

}
