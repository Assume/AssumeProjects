package com.zork.api.types.bottomlevel.items.weapon;

import com.zork.api.types.toplevel.items.MeleeWeapon;

public class Sword extends MeleeWeapon
{

    private static final int BAG_SPACE = 3;
    private static final String DESCRIPTION = "a SWORD that can be used to kill.";
    private static final int STRENGTH = 15;
    
    private String storyDescription;
    
    public Sword(String storyDescription)
    {
	this(DESCRIPTION, BAG_SPACE, STRENGTH);
	this.storyDescription = storyDescription;
    }
    
    public String storyDescription() {
	    return this.storyDescription;
    }
    
    private Sword(String description, int bagSpace, int strength)
    {
	super(description, bagSpace, strength);
    }

}
