package com.zork.api.types.bottomlevel.bag;

import java.util.ArrayList;
import java.util.List;
import com.zork.api.types.toplevel.items.Item;

public class Bag {

	private int size;
	private List<Item> items;

	public Bag() {
		this.size = 15;
		this.items = new ArrayList<Item>();
	}

	public void incrementSize(int amount) {
		this.size += amount;
	}

	public Bag remove(Item item) {
		items.remove(item);
		return this;
	}

	public Item getItemForName(String name) {
		for (Item x : this.getItems()) {
			if (x.getClass().getSimpleName().equalsIgnoreCase(name)) {
				return x;
			}
		}
		return null;
	}

	public Bag removeItemForName(String name) {
		for (Item x : this.getItems()) {
			if (x.getClass().getSimpleName().equalsIgnoreCase(name)) {
				items.remove(x);
				this.size += x.getBagSpace();
				break;
			}
		}
		return this;
	}

	public Bag add(Item item) {
		items.add(item);
		size -= item.getBagSpace();
		return this;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean hasItem(String name) {
		for (Item x : this.items) {
			if (x.getClass().getSimpleName().toLowerCase().equals(name))
				return true;
		}
		return false;

	}
}
