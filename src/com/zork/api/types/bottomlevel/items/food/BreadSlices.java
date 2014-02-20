package com.zork.api.types.bottomlevel.items.food;

import com.zork.api.types.toplevel.items.Food;
import com.zork.api.types.toplevel.items.Item;
import com.zork.api.types.toplevel.items.Tool;

public class BreadSlices extends Food
{

    private static final String DESCRIPTION = "BREADSLICES that heals 2";
    private static final int HEAL_AMOUNT = 2;
    private static final Item USE_TYPE = null;
    private static final int BAG_SPACE = 2;
    
    private String storyDescription;

    public BreadSlices(String storyDescription)
    {
	this(DESCRIPTION, BAG_SPACE, USE_TYPE, HEAL_AMOUNT);
	this.storyDescription = storyDescription;
    }

    private BreadSlices(String description, int bagSpace, Item makes,
	    int healAmount)
    {
	super(description, bagSpace, makes, healAmount, new Tool[] {});
    }

    public String getStoryDescription() {
	    return storyDescription;
    }
    
    @Override
    public boolean isUsable(Tool item)
    {
	return false;
    }

    @Override
    public void use(Tool item)
    {
	return;
    }

}
