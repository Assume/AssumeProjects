package com.zork.api.types.bottomlevel.user;

import java.util.List;
import com.zork.api.types.bottomlevel.bag.Bag;
import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.bottomlevel.items.Abilities.Abilities;
import com.zork.api.types.bottomlevel.rooms.Room;
import com.zork.api.types.interfaces.Fightable;
import com.zork.api.types.interfaces.Playable;
import com.zork.api.types.toplevel.items.Item;
import com.zork.api.types.toplevel.items.Weapon;

public class Player implements Playable {

	private Room currentRoom;
	private Room lastRoom;
	private int health;
	private Weapon weapon;
	private Bag bag;
	private int baseAttackStrength;
	private Abilities ability;

	public Player() {
		currentRoom = Game.getInitialRoom();
		lastRoom = null;
		this.health = 100;
		this.weapon = null;
		this.bag = new Bag();
		baseAttackStrength = 0;
		this.ability = null;
	}

	@Override
	public Room getLocation() {
		return this.currentRoom;
	}

	public void setAbility(Abilities ability) {
		this.ability = ability;
		this.ability.giveAbility();
	}

	public Abilities getAbility() {
		return this.ability;
	}

	@Override
	public Item getItemForName(String name) {
		return this.getBag().getItemForName(name);
	}

	@Override
	public int getHealth() {
		return health;
	}

	public boolean isUsingAbility() {
		return this.getAbility() != null;
	}

	@Override
	public int decrementHealth(int amount) {
		this.health -= amount;
		return this.health;
	}

	@Override
	public int incrementHealth(int amount) {
		this.health += amount;
		return this.health;
	}

	@Override
	public int getAttackStrength(Fightable monster) {
		if (this.weapon != null)
			return (int) ((this.weapon.getStrength()
					+ this.baseAttackStrength + this.getHealth() * .75))
					/ monster.getDefenseLevel();
		else
			return (int) (((this.getHealth()) + this.baseAttackStrength) * .75)
					/ monster.getDefenseLevel();

	}

	public int getBaseAttackStrength() {
		return baseAttackStrength;
	}

	public void incrementBaseAttackStrength(int x) {
		baseAttackStrength += x;
	}

	@Override
	public int getDefenseLevel(Fightable monster) {
		return (int) ((getAttackStrength(monster) + (getHealth() / 2)) / 2);
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public Room getLastRoom() {
		return lastRoom;
	}

	public void setLastRoom(Room lastRoom) {
		this.lastRoom = lastRoom;
	}

	public List<Item> getItems() {
		return this.getBag().getItems();
	}

	public Bag getBag() {
		return this.bag;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Weapon wep) {
		this.weapon = wep;
	}

}
