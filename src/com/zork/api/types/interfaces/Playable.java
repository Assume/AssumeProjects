package com.zork.api.types.interfaces;

import com.zork.api.types.bottomlevel.rooms.Room;
import com.zork.api.types.toplevel.items.Item;

public interface Playable
{

    public Room getLocation();
    
    public Item getItemForName(String name);
    
    public int getHealth();
    
    public int decrementHealth(int amount);
    
    public int incrementHealth(int amount);
    
    public int getAttackStrength(Fightable monster);

    public int getDefenseLevel(Fightable monster);
}
