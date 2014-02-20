package com.zork.api.types.interfaces;

import com.zork.api.types.bottomlevel.doors.Door;

public interface Enterable
{

	public boolean hasMonster(String name);
	
	public boolean hasItem(String name);
	
	public void setExit(String direction, Door door, boolean isOpen);
	
	public boolean hasDoor(String dir);
	
	public void takeItem(String name);
	
}
