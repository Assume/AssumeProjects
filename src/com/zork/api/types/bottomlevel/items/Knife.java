package com.zork.api.types.bottomlevel.items;

import com.zork.api.types.toplevel.items.Tool;

public class Knife extends Tool {

	private static final String DESCRIPTION = "a KNIFE that cuts things";
	private static final int BAG_SPACE = 1;
	
	private String storyDescription;
	
	public Knife(String storyDescription)
	{
		this(DESCRIPTION, BAG_SPACE);
		this.storyDescription = storyDescription;
	}
	
	public String getStoryDescription() {
		return this.storyDescription;
	}
	
	private Knife(String description, int bagSpace) {
		super(description,  bagSpace);
	}

}
