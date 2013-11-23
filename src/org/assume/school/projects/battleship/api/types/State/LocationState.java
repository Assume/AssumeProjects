package org.assume.school.projects.battleship.api.types.State;

public enum LocationState
{

	EMPTY('e'), PEG('X'), SHIP_PART('S'), SHIP_HIT('H');
	
	char c;
	
	LocationState(char c)
	{
		this.c = c;
	}
	
	public char getChar()
	{
		return this.c;
	}
	
}
