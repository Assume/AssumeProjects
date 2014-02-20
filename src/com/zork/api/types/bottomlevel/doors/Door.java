package com.zork.api.types.bottomlevel.doors;

import java.util.Random;
import com.zork.api.types.bottomlevel.rooms.Room;

public class Door {

	private boolean isOpen;
	private Room room;
	
	public Door(Room room)
	{
		this.room = room;
		this.isOpen = new Random().nextBoolean();
	}
	
	public boolean isOpen()
	{
		return this.isOpen;
	}
	
	public void setOpen(boolean value) {
		 this.isOpen = value;
	}
	
	public Room getNextRoom()
	{
		return this.room;
	}
	
}
