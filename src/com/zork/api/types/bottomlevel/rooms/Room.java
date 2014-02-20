package com.zork.api.types.bottomlevel.rooms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.zork.api.types.bottomlevel.doors.Door;
import com.zork.api.types.bottomlevel.doors.Ladder;
import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.Abilities.Abilities;
import com.zork.api.types.interfaces.Enterable;
import com.zork.api.types.interfaces.Fightable;
import com.zork.api.types.npcs.NPC;
import com.zork.api.types.toplevel.items.Item;

public class Room implements Enterable {
	public static List<Room> roomsInUse = new ArrayList<Room>();

	private String description;

	private List<NPC> npcsInRoom;
	private List<Item> itemsInRoom;
	private List<Abilities> abilitiesInRoom;

	private Map<String, Door> doors;

	public Room(String description) {
		this.description = description;
		this.doors = new HashMap<String, Door>();
		npcsInRoom = new ArrayList<NPC>();
		itemsInRoom = new ArrayList<Item>();
		abilitiesInRoom = new ArrayList<Abilities>();
		roomsInUse.add(this);
	}

	public Map<String, Door> getDoors() {
		return this.doors;
	}

	public void setMonstersInRoom(List<NPC> npc) {
		this.npcsInRoom = npc;
	}

	public void setAbilitiesInRoom(List<Abilities> abilities) {
		this.abilitiesInRoom = abilities;
	}

	public void addAbilityToRoom(Abilities ability) {
		this.abilitiesInRoom.add(ability);
	}

	public void addItemToRoom(Item item) {
		this.itemsInRoom.add(item);
	}

	public void setItemsInRoom(List<Item> items) {
		this.itemsInRoom = items;
	}

	public boolean hasAbility(String name) {
		for (Abilities x : abilitiesInRoom) {
			if (x.getClass().getSimpleName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	public Abilities getAbilityForName(String name) {
		for (Abilities x : abilitiesInRoom) {
			if (x.getClass().getSimpleName().equalsIgnoreCase(name)) {
				return x;
			}
		}
		return null;
	}

	public void removeAbilityForName(String name) {
		for (Abilities x : abilitiesInRoom) {
			if (x.getClass().getSimpleName().equalsIgnoreCase(name)) {
				this.abilitiesInRoom.remove(x);
				return;
			}
		}
	}

	private void removeItemForName(String name) {
		for (Item x : itemsInRoom) {
			if (x.getClass().getSimpleName().equalsIgnoreCase(name)) {
				this.itemsInRoom.remove(x);
				return;
			}
		}
	}

	public void removeCharacter(Fightable x) {
		this.npcsInRoom.remove(x);
	}

	public Item getItemForName(String name) {
		for (Item x : itemsInRoom) {
			if (x.getClass().getSimpleName().equalsIgnoreCase(name))
				return x;
		}
		return null;
	}

	@Override
	public boolean hasMonster(String name) {
		for (NPC x : this.npcsInRoom) {
			if (x.getClass().getSimpleName().toLowerCase().equals(name))
				return true;
		}
		return false;
	}

	public Fightable getMonster(String name) {
		for (NPC x : this.npcsInRoom) {
			if (x.getClass().getSimpleName().toLowerCase().equals(name))
				return ((Fightable) x);
		}
		return null;
	}

	@Override
	public boolean hasItem(String name) {
		for (Item x : this.itemsInRoom) {
			if (x.getClass().getSimpleName().toLowerCase().equals(name))
				return true;
		}
		return false;

	}

	@Override
	public void setExit(String direction, Door door, boolean isOpen) {
		door.setOpen(isOpen);
		this.doors.put(direction.toLowerCase(), door);

	}

	@Override
	public boolean hasDoor(String dir) {
		return doors.containsKey(dir);
	}

	@Override
	public void takeItem(String name) {
		if (Game.getGame().getBag().getSize()
				- this.getItemForName(name).getBagSpace() >= 0) {
			Game.getGame().getBag().add(this.getItemForName(name));
			this.removeItemForName(name);
		}
		else
			System.out.println("You don't have enough space in your bag for that. Try removing a different item. Type \"items\" for the things currently in your bag.");

	}

	public Door getDoor(String dir) {
		return this.doors.get(dir);
	}

	public String showMonsters() {
		String string = "";
		for (NPC x : npcsInRoom) {
			string += x.getDescription();
		}
		return string;
	}

	public String showItems() {
		String string = "";
		if (!itemsInRoom.isEmpty()) {
			string += "\nThe room has a few items up for grabs: \n";
		}
		for (Item x : itemsInRoom) {
			string += "\t" + x.description() + "\n";
		}
		return string;
	}

	public String showAbilities() {
		String string = "";
		if (!abilitiesInRoom.isEmpty()) {
			string += "\nThe room has a few abilities up for grabs: \n";
		}
		for (Abilities x : abilitiesInRoom) {
			string += "\t" + x.getDescription() + "\n";
		}
		return string;
	}

	public void removeAbilityFromRoom(Abilities ability) {
		abilitiesInRoom.remove(ability);
	}

	public String showExits() {
		Set<String> keys = doors.keySet();
		Collection<Door> values = doors.values();
		String exits = "\nThe door(s) are: ";
		String[] locs = keys.toArray(new String[keys.size()]);
		Door[] doors = values.toArray(new Door[values.size()]);
		for (int i = 0; i < locs.length; i++) {
			if (doors[i] instanceof Ladder)
				continue;
			exits += locs[i];
			if (doors[i].isOpen()) {
				exits += i < locs.length - 1 ? "(open), " : "(open)";
			}
			else
				exits += i < locs.length - 1 ? "(closed), "
						: "(closed)";
		}
		if (hasLadder(values)) {
			exits += "\nThe ladder(s) are: ";
		}
		for (int i = 0; i < locs.length; i++) {
			if (!(doors[i] instanceof Ladder))
				continue;
			exits += locs[i];
		}

		return exits;
	}

	public boolean hasLadder(Collection<Door> doors) {
		for (Door x : doors) {
			if (x instanceof Ladder) {
				return true;
			}
			else
				return false;
		}
		return false;
	}

	public String getDescription() {
		return description + showMonsters() + showItems() + showAbilities()
				+ showExits();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.getDescription();
	}

	@Override
	public boolean equals(Object ob) {
		return ob.getClass().getSimpleName()
				.equals(this.getClass().getSimpleName());
	}

}
