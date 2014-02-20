package com.zork.api.types.bottomlevel.items.Abilities;

import java.util.Collection;
import com.zork.api.types.bottomlevel.doors.Door;
import com.zork.api.types.bottomlevel.rooms.Room;


public class OpenDoorsAbility implements Abilities {
	public static final String DESCRIPTION = "the OPENDOORSABILITY: a one-use opportunity to open all doors in the game";

	@Override
	public void giveAbility() {
		for (Room r : Room.roomsInUse) {
			Collection<Door> doors = r.getDoors().values();
			for (Door d : doors) {
				d.setOpen(true);
			}
		}
		System.out.println("All doors in the game are now open.");
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
