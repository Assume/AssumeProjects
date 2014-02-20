package com.zork.api.types.toplevel.items;

public abstract class Item
{

    private String description;
    private String storyDescription;
    private int bagSpace;

    public Item(String description, int bagSpace)
    {
	this.description = description;
	this.bagSpace = bagSpace;
    }
    
    public int getBagSpace() {
	    return bagSpace;
    }

    public String description()
    {
	return this.description;
    }
    
    public String getStoryDescription() {
	    return storyDescription;
    }

    @Override
    public boolean equals(Object ob)
    {
	return this.getClass().getSimpleName()
		.equals(ob.getClass().getSimpleName());
    }

}
