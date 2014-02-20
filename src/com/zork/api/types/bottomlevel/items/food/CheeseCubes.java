package com.zork.api.types.bottomlevel.items.food;

import com.zork.api.types.toplevel.items.Food;
import com.zork.api.types.toplevel.items.Item;
import com.zork.api.types.toplevel.items.Tool;

public class CheeseCubes extends Food {
	 private static final String DESCRIPTION = "CHEESECUBES that heals 4";
	    private static final int HEAL_AMOUNT = 4;
	    private static final Item USE_TYPE = null;
	    private static final int BAG_SPACE = 1;
	    
	    private String storyDescription;

	    public CheeseCubes(String storyDescription)
	    {
		this(DESCRIPTION, BAG_SPACE, USE_TYPE, HEAL_AMOUNT);
		this.storyDescription = storyDescription;
	    }

	    private CheeseCubes(String description, int bagSpace, Item makes,
		    int healAmount)
	    {
		super(description, bagSpace, makes, healAmount, new Tool[] {});
	    }

	    public String getStoryDescription() {
		    return this.storyDescription;
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
