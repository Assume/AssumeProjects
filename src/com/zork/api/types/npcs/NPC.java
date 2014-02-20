package com.zork.api.types.npcs;


public abstract class NPC {
	public abstract String getDescription();
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
