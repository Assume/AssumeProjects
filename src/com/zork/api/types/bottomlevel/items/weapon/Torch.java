package com.zork.api.types.bottomlevel.items.weapon;

import com.zork.api.types.toplevel.items.MeleeWeapon;

public class Torch extends MeleeWeapon
{

    private static final int BAG_SPACE = 2;
    private static final String DESCRIPTION = "a TORCH that can be used to kill.";
    private static final int STRENGTH = 13;
    
    private String storyDescription;
    
    public Torch(String storyDescription)
    {
	this(DESCRIPTION, BAG_SPACE, STRENGTH);
	this.storyDescription = storyDescription;
    }
    
    public String storyDescription() {
	    return this.storyDescription;
    }
    
    private Torch(String description, int bagSpace, int strength)
    {
	super(description, bagSpace, strength);
    }

}
