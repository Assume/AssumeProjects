package com.zork.api.types.bottomlevel.npcs.fightable;

import java.util.Random;
import com.zork.api.types.bottomlevel.items.ValidItems;
import com.zork.api.types.interfaces.Fightable;
import com.zork.api.types.npcs.NPC;
import com.zork.api.types.toplevel.items.Item;

public class DrMcCarthy extends NPC implements Fightable {
		int defenseLevel;
		int attackStrength;
		String description;
		boolean isAlive;
		
		public DrMcCarthy(String description) {
			this.defenseLevel = 40;
			this.attackStrength = 90;
			this.randomizeDeathDrops();
			this.description = description;
		}
		
		public void checkIfAlive() {
			
		}
		
		public String getDescription() {
			return this.description;
		}
	    
	    //add items as we go. When the monster dies it will drops these
	    private Item[] onDeathDrops = new Item[5];
	    
	    public void randomizeDeathDrops() {
		    Item[] items = ValidItems.VALID_ITEMS;
		    Random r = new Random();
		    
		    for (int i = 0; i < onDeathDrops.length; i++) {
			   int  x = r.nextInt(items.length);
			    onDeathDrops[i] = items[x];
		    }
	    }
	    
	    @Override
	    public void decrementDefenseLevel(int x) {
		    defenseLevel -= x;
	    }
	    
	    //should be between 10 and 50
	    @Override
	    public int getDefenseLevel()
	    {
		return defenseLevel;
	    }

	    
	    //should be between 10 and 50
	    @Override
	    public int getAttackStrength()
	    {
		return attackStrength;
	    }

	    @Override
	    public Item[] onDeathDrops()
	    {
		return onDeathDrops;
	    }
}
