package com.zork.api.types.bottomlevel.items;

import java.util.Random;
import com.zork.api.types.bottomlevel.rooms.Room;
import com.zork.api.types.toplevel.items.Item;

public class MagicalOrb extends Item {
	Room nextRoom;
	private static final int BAG_SPACE = 3;
	private static final String DESCRIPTION = "MAGICALORB that can transport you to a random room";

	public MagicalOrb() {
		super(DESCRIPTION, BAG_SPACE);
		randomizeNextRoom();
	}

	public void randomizeNextRoom() {
		Random r = new Random();
		int i = r.nextInt(Room.roomsInUse.size());
		Room room = Room.roomsInUse.get(i);
		this.nextRoom = room;
	}

	public Room getNextRoom() {
		return nextRoom;
	}

}
